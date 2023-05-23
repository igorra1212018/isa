package com.isa.donorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.donorapp.dto.DonationCenterDTO;
import com.isa.donorapp.dto.StaffDTO;
import com.isa.donorapp.dto.UserProfileDTO;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.User;
import com.isa.donorapp.service.StaffService;
import com.isa.donorapp.service.UserService;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@Autowired
	UserService userService;
		
	@GetMapping("/profile")
	public ResponseEntity<UserProfileDTO> getUserProfile() {
		User user = getCurrentUser();
		UserProfileDTO userDTO = new UserProfileDTO(user);
		
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
		
	@PutMapping("/update")
	public ResponseEntity<StaffDTO> UpdateStaffInfo(@RequestBody StaffDTO newData) {
		StaffDTO updatedStaffDTO = new StaffDTO(staffService.updateStaff(newData));
		
		return new ResponseEntity<>(updatedStaffDTO, HttpStatus.OK);
	}
	
	private User getCurrentUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByEmail(currentUserEmail);
	}
	
}
