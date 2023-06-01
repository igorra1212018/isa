package com.isa.donorapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.isa.donorapp.dto.DonationCenterComplaintCreateDTO;
import com.isa.donorapp.dto.DonationCenterComplaintDTO;
import com.isa.donorapp.dto.StaffDTO;
import com.isa.donorapp.dto.UserRegisterDTO;
import com.isa.donorapp.event.OnRegistrationCompleteEvent;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.DonationCenterComplaint;
import com.isa.donorapp.model.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.service.DonationCenterComplaintService;
import com.isa.donorapp.service.DonationCenterService;
import com.isa.donorapp.service.ReservationService;
import com.isa.donorapp.service.UserDetailsServiceImpl;
import com.isa.donorapp.service.UserService;

@RestController
@RequestMapping("/api/donation_center_complaint")
public class DonationCenterComplaintController {
	@Autowired
	DonationCenterComplaintService donationCenterComplaintService;
	@Autowired
	UserService userService;
	@Autowired
	DonationCenterService donationCenterService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	/*
	@GetMapping("/all")
	//@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<DonationCenterComplaintDTO>> getAllDonationCenterComplaints() {
		try {
			List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintService.findAll();
			List<DonationCenterComplaintDTO> donationCenterComplaintDtos = new ArrayList<DonationCenterComplaintDTO>();
			for (DonationCenterComplaint dc : donationCenterComplaints) {
				donationCenterComplaintDtos.add(new DonationCenterComplaintDTO(dc));
			}
			return new ResponseEntity<>(donationCenterComplaintDtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("isAuthenticated()")
	public ResponseEntity<DonationCenterComplaintDTO> getDonationCenterComplaintById(@PathVariable("id") int id) {
		DonationCenterComplaint donationCenterComplaintData = donationCenterComplaintService.findById(id);
		if (donationCenterComplaintData != null) {
			DonationCenterComplaintDTO donationCenterComplaintDto = new DonationCenterComplaintDTO(donationCenterComplaintData);
			return new ResponseEntity<>(donationCenterComplaintDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/staff_center")
	//@PreAuthorize("isAuthenticated()")
	public ResponseEntity<DonationCenterComplaintDTO> getDonationCenterComplaintByStaffId() 
	{
		User user = getCurrentUser();
		try 
		{
			DonationCenterComplaint donationCenterComplaintData = donationCenterComplaintService.findById(user.getDonationCenterComplaint().getId());
			DonationCenterComplaintDTO donationCenterComplaintDto = new DonationCenterComplaintDTO(donationCenterComplaintData);
			
			return new ResponseEntity<>(donationCenterComplaintDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	*/
	@PostMapping("/create")
	@Secured("ROLE_USER")
	public ResponseEntity<String> createComplaint(@RequestBody DonationCenterComplaintCreateDTO complaintDTO, HttpServletRequest request)
	{
		try {
			User currentUser = getCurrentUser();
			DonationCenter center = donationCenterService.findById(complaintDTO.getCenterId());
			if (canFileComplaint(center.getId())) {
				DonationCenterComplaint newComplaint = new DonationCenterComplaint(complaintDTO, center, currentUser);
				donationCenterComplaintService.create(newComplaint);
				
				return new ResponseEntity<>("Complaint creation successful", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*
	@PutMapping("/update")
	public ResponseEntity<DonationCenterComplaint> updateDonationCenterComplaint(@RequestBody DonationCenterComplaintDTO newData){
		User user = getCurrentUser();
		DonationCenterComplaint newCenter = new DonationCenterComplaint(newData);
		donationCenterComplaintService.update(newCenter, user.getDonationCenterComplaint().getId());
		
		return new ResponseEntity<>(newCenter, HttpStatus.OK);
	}
	*/
	
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
	private User getCurrentUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByEmail(currentUserEmail);
	}
}