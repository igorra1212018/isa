package com.isa.donorapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.isa.donorapp.dto.StaffComplaintCreateDTO;
import com.isa.donorapp.dto.StaffComplaintDTO;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.StaffComplaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.service.ReservationService;
import com.isa.donorapp.service.StaffComplaintService;
import com.isa.donorapp.service.UserDetailsServiceImpl;
import com.isa.donorapp.service.UserService;

@RestController
@RequestMapping("/api/staff_complaint")
public class StaffComplaintController {
	@Autowired
	StaffComplaintService staffComplaintService;
	@Autowired
	UserService userService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@GetMapping("/user")
	@Secured("ROLE_USER")
	public ResponseEntity<List<StaffComplaintDTO>> getUserComplaints() {
		try {
			User currentUser = getCurrentUser();
			List<StaffComplaint> staffComplaints = staffComplaintService.findByUserId(currentUser.getId());
			List<StaffComplaintDTO> staffComplaintDTOs = new ArrayList<StaffComplaintDTO>();
			for (StaffComplaint sc : staffComplaints) {
				staffComplaintDTOs.add(new StaffComplaintDTO(sc));
			}
			return new ResponseEntity<>(staffComplaintDTOs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/no_reply")
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<List<StaffComplaintDTO>> getNoReplyComplaints() {
		try {
			List<StaffComplaint> staffComplaints = staffComplaintService.findByNoReply();
			List<StaffComplaintDTO> staffComplaintDTOs = new ArrayList<StaffComplaintDTO>();
			for (StaffComplaint sc : staffComplaints) {
				staffComplaintDTOs.add(new StaffComplaintDTO(sc));
			}
			return new ResponseEntity<>(staffComplaintDTOs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/replied")
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<List<StaffComplaintDTO>> getRepliedComplaints() {
		try {
			List<StaffComplaint> staffComplaints = staffComplaintService.findByReplied();
			List<StaffComplaintDTO> staffComplaintDTOs = new ArrayList<StaffComplaintDTO>();
			for (StaffComplaint sc : staffComplaints) {
				staffComplaintDTOs.add(new StaffComplaintDTO(sc));
			}
			return new ResponseEntity<>(staffComplaintDTOs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	@Secured("ROLE_USER")
	public ResponseEntity<String> createComplaint(@RequestBody StaffComplaintCreateDTO complaintDTO, HttpServletRequest request)
	{
		try {
			User currentUser = getCurrentUser();
			User staff = userService.findById(complaintDTO.getStaffId());
			if (staff.getDonationCenter() != null && canFileComplaint(staff.getDonationCenter().getId())) {
				StaffComplaint newComplaint = new StaffComplaint(complaintDTO, staff, currentUser);
				staffComplaintService.create(newComplaint);
				
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