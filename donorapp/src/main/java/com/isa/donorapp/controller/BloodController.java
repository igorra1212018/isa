package com.isa.donorapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.donorapp.model.Blood;
import com.isa.donorapp.model.User;
import com.isa.donorapp.service.BloodService;
import com.isa.donorapp.service.UserService;

@RestController
@RequestMapping("/api/blood")
public class BloodController {

	@Autowired
	BloodService bloodService;
	
	@GetMapping("/all")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Blood>> getAllBloods() {
		
		try {
			List<Blood> bloods = bloodService.findAll();
			if (bloods.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(bloods, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Blood> getUserById(@PathVariable("id") Integer id) {
		Blood blood = bloodService.findById(id);
		if (blood != null) {
			return new ResponseEntity<>(blood, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
