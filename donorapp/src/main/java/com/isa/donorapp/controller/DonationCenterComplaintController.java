package com.isa.donorapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.isa.donorapp.dto.ComplaintReplyDTO;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/user")
	@Secured("ROLE_USER")
	public ResponseEntity<List<DonationCenterComplaintDTO>> getUserComplaints() {
		try {
			User currentUser = getCurrentUser();
			List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintService.findByUserId(currentUser.getId());
			List<DonationCenterComplaintDTO> donationCenterComplaintDtos = new ArrayList<DonationCenterComplaintDTO>();
			for (DonationCenterComplaint dc : donationCenterComplaints) {
				donationCenterComplaintDtos.add(new DonationCenterComplaintDTO(dc));
			}
			return new ResponseEntity<>(donationCenterComplaintDtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/no_reply")
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<List<DonationCenterComplaintDTO>> getNoReplyComplaints() {
		try {
			List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintService.findByNoReply();
			List<DonationCenterComplaintDTO> donationCenterComplaintDTOs = new ArrayList<DonationCenterComplaintDTO>();
			for (DonationCenterComplaint dc : donationCenterComplaints) {
				donationCenterComplaintDTOs.add(new DonationCenterComplaintDTO(dc));
			}
			return new ResponseEntity<>(donationCenterComplaintDTOs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/replied")
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<List<DonationCenterComplaintDTO>> getRepliedComplaints() {
		try {
			List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintService.findByReplied();
			List<DonationCenterComplaintDTO> donationCenterComplaintDTOs = new ArrayList<DonationCenterComplaintDTO>();
			for (DonationCenterComplaint dc : donationCenterComplaints) {
				donationCenterComplaintDTOs.add(new DonationCenterComplaintDTO(dc));
			}
			return new ResponseEntity<>(donationCenterComplaintDTOs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
	
	
	@PutMapping("/reply")
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<String> reply(@RequestBody ComplaintReplyDTO replyDTO) {
		DonationCenterComplaint complaint = donationCenterComplaintService.findById(replyDTO.getId());
		if (complaint == null) {
			return new ResponseEntity<>("Complaint not found.", HttpStatus.NOT_FOUND);
		}
		complaint.setReply(replyDTO.getReply());
		donationCenterComplaintService.reply(complaint);
		
		return new ResponseEntity<>("Reply successful.", HttpStatus.OK);
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