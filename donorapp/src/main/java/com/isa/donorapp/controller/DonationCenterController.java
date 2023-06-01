package com.isa.donorapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.isa.donorapp.dto.CenterFileComplaintDTO;
import com.isa.donorapp.dto.DonationCenterDTO;
import com.isa.donorapp.dto.StaffDTO;
import com.isa.donorapp.dto.StaffFileComplaintDTO;
import com.isa.donorapp.dto.UserRegisterDTO;
import com.isa.donorapp.event.OnRegistrationCompleteEvent;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.model.enums.ERole;
import com.isa.donorapp.service.DonationCenterService;
import com.isa.donorapp.service.ReservationService;
import com.isa.donorapp.service.StaffService;
import com.isa.donorapp.service.UserDetailsServiceImpl;
import com.isa.donorapp.service.UserService;

@RestController
@RequestMapping("/api/donation_center")
public class DonationCenterController {
	@Autowired
	DonationCenterService donationCenterService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	UserService userService;
	@Autowired
	StaffService staffService;
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@GetMapping("/all")
	//@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<DonationCenterDTO>> getAllDonationCenters() {
		try {
			List<DonationCenter> donationCenters = donationCenterService.findAll();
			List<DonationCenterDTO> donationCenterDtos = new ArrayList<DonationCenterDTO>();
			for (DonationCenter dc : donationCenters) {
				DonationCenterDTO centerDTO = new DonationCenterDTO(dc);
				if (isAuthenticated() && canFileComplaint(dc.getId()))
					centerDTO.setCanComplain(true);
				donationCenterDtos.add(centerDTO);
			}
			return new ResponseEntity<>(donationCenterDtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("isAuthenticated()")
	public ResponseEntity<DonationCenterDTO> getDonationCenterById(@PathVariable("id") int id) {
		DonationCenter donationCenterData = donationCenterService.findById(id);
		if (donationCenterData != null) {
			DonationCenterDTO donationCenterDto = new DonationCenterDTO(donationCenterData);
			if (isAuthenticated() && canFileComplaint(donationCenterData.getId()))
				donationCenterDto.setCanComplain(true);
			return new ResponseEntity<>(donationCenterDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	private boolean canFileComplaint(Integer centerId) {
		User currentUser = getCurrentUser();
		List<Reservation> reservations = reservationService.findByUserId(currentUser.getId());
		for (Reservation r : reservations) {
			if (r.getTerm().getCenter().getId() == centerId && r.getStatus() == EReservationStatus.PROCESSED) {
				return true;
			}
		}
		return false;
	}
	
	@GetMapping("/file_complaint/{id}")
	@Secured("ROLE_USER")
	public ResponseEntity<CenterFileComplaintDTO> getCenterFileComplaintById(@PathVariable("id") int id) {
		DonationCenter donationCenter = donationCenterService.findById(id);
		List<User> staff = staffService.findByCenterId(id);
		if (donationCenter != null) {
			if (canFileComplaint(id)) {
				CenterFileComplaintDTO centerDTO = new CenterFileComplaintDTO(donationCenter, staff);
				return new ResponseEntity<>(centerDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			}
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/staff_center")
	//@PreAuthorize("isAuthenticated()")
	public ResponseEntity<DonationCenterDTO> getDonationCenterByStaffId() 
	{
		User user = getCurrentUser();
		try 
		{
			DonationCenter donationCenterData = donationCenterService.findById(user.getDonationCenter().getId());
			DonationCenterDTO donationCenterDto = new DonationCenterDTO(donationCenterData);
			
			return new ResponseEntity<>(donationCenterDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCenter(@RequestBody DonationCenterDTO donationCenterDTO, HttpServletRequest request){
		DonationCenter newCenter = new DonationCenter(donationCenterDTO);
		donationCenterService.save(newCenter);
		
		return new ResponseEntity<>(
			      "Registration successful!",
			      HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<DonationCenter> updateDonationCenter(@RequestBody DonationCenterDTO newData){
		User user = getCurrentUser();
		DonationCenter newCenter = new DonationCenter(newData);
		donationCenterService.update(newCenter, user.getDonationCenter().getId());
		
		return new ResponseEntity<>(newCenter, HttpStatus.OK);
	}
	
	private User getCurrentUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByEmail(currentUserEmail);
	}
	
	private boolean isAuthenticated() {
		User currentUser = getCurrentUser();
		return currentUser != null;
	}
}