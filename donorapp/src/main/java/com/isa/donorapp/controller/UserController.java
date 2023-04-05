package com.isa.donorapp.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.isa.donorapp.dto.UserRegisterDTO;
import com.isa.donorapp.model.User;
import com.isa.donorapp.service.UserService;
import com.isa.donorapp.repository.TokenRepository;
import com.isa.donorapp.model.VerificationToken;
import com.isa.donorapp.event.OnRegistrationCompleteEvent;
import com.isa.donorapp.jwt.JwtUtils;


@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		
		try {
			List<User> users = userService.findAll();
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(users, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User user = userService.findById(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/register")
	@PreAuthorize("not(isAuthenticated())")
	public ResponseEntity<String> register(@RequestBody UserRegisterDTO signUpRequest, HttpServletRequest request)
	{
		if (userService.findByEmail(signUpRequest.getEmail()) != null) {
			return ResponseEntity
					.badRequest()
					.body("Email already taken!");
		}
		signUpRequest.setPassword(encoder.encode(signUpRequest.getPassword()));
		signUpRequest.setPassword(signUpRequest.getPassword());
		User registeredUser = new User(signUpRequest);
		
		userService.registerUser(registeredUser);
		String appUrl = request.getContextPath();

        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registeredUser,
          request.getLocale(), appUrl));
		return new ResponseEntity<>(
			      "Registration successful!", 
			      HttpStatus.OK);
	}
	
	@GetMapping("/registration_confirm")
	public ResponseEntity<String> confirmRegistration(@RequestParam("token") String token) {
		
	    VerificationToken verificationToken = tokenRepository.findByToken(token).orElse(null);
	    if (verificationToken == null) {
	    	return new ResponseEntity<>(
				      "Verification token not found!", 
				      HttpStatus.NOT_FOUND);
	    }
	    
	    User user = verificationToken.getUser();
	    Calendar cal = Calendar.getInstance();
	    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	    	return new ResponseEntity<>(
				      "Verification token expired!", 
				      HttpStatus.BAD_REQUEST);
	    } 
	    
	    user.setActivated(true); 
	    userService.save(user); 
	    return new ResponseEntity<>(
			      "Successful verification!", 
			      HttpStatus.OK);
	}
}