package com.isa.donorapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.model.User;
import com.isa.donorapp.repository.UserRepository;
import com.isa.donorapp.dto.UserProfileDTO;
import com.isa.donorapp.model.Location;
import com.isa.donorapp.model.Role;
import com.isa.donorapp.model.enums.ERole;
import com.isa.donorapp.repository.RoleRepository;
import com.isa.donorapp.repository.TokenRepository;
import com.isa.donorapp.model.VerificationToken;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenRepository tokenRepository;
	@Autowired
	private RoleRepository roleRepository;

	public User registerUser(User user)
	{
		Role userRole = roleRepository.findByName(ERole.USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		user.getRoles().add(userRole);
		//user.setActivated(true);
		return userRepository.save(user);
	}
	
	public User findByEmail(String email)
	{
		Optional<User> foundUser = userRepository.findByEmail(email);
		if(foundUser.isEmpty())
			return null;
		else
			return foundUser.get();
	}
	
	public User findById(Integer id)
	{
		Optional<User> foundUser = userRepository.findById(id);
		if(foundUser.isEmpty())
			return null;
		else
			return foundUser.get();
	}
	
	public List<User> findAll()
	{
		List<User> users = userRepository.findAll();
		return users;
	}
	
    public void createVerificationTokenForUser(final User user, final String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
        VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken).orElse(null);
        if(vToken == null)
        	return null;
        vToken.updateToken(UUID.randomUUID()
            .toString());
        vToken = tokenRepository.save(vToken);
        return vToken;
    }
    
	public User save(User user)
	{
		Role userRole = roleRepository.findByName(ERole.USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		user.getRoles().add(userRole);
		return userRepository.save(user);
	}
	public User getLoggedUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.print(currentUserEmail);
		return findByEmail(currentUserEmail);
	}

	public User updateUser(User user) {
		userRepository.save(user);
		
		return user;
	}
	
    public void resetUserAttributeToZero() {
        List<User> users = userRepository.findAll();
        for (User u : users) {
            u.setPenaltyCount(0);
        }
        userRepository.saveAll(users);
    }
}
