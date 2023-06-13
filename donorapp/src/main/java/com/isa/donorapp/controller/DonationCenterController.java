package com.isa.donorapp.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.isa.donorapp.dto.AppointmentDTO;
import com.isa.donorapp.dto.CenterFileComplaintDTO;
import com.isa.donorapp.dto.DeliveryCoordinatesDTO;
import com.isa.donorapp.dto.DonationCenterDTO;
import com.isa.donorapp.dto.DonationCenterScoreDTO;
import com.isa.donorapp.dto.StaffDTO;
import com.isa.donorapp.dto.StaffFileComplaintDTO;
import com.isa.donorapp.dto.TermDTO;
import com.isa.donorapp.dto.UserRegisterDTO;
import com.isa.donorapp.event.OnRegistrationCompleteEvent;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.DonationCenterScore;
import com.isa.donorapp.model.LoyaltyProgram;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.Role;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.client.RestTemplate;

import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.model.enums.ERole;
import com.isa.donorapp.service.DonationCenterScoreService;
import com.isa.donorapp.service.DonationCenterService;
import com.isa.donorapp.service.LoyaltyProgramService;
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
	DonationCenterScoreService donationCenterScoreService;
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	LoyaltyProgramService loyaltyProgramService;
	
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
	
	
	@PostMapping("/start_delivery")
	@Secured({"ROLE_STAFF", "ROLE_ADMINISTRATOR"})
	public ResponseEntity<String> startDelivery(@RequestBody DeliveryCoordinatesDTO coordinatesDTO, HttpServletRequest request){
		String locationSimulatorUrl = "http://localhost:5000/endpoint";

	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    JSONObject coordJsonObject = new JSONObject();
	    coordJsonObject.put("start_latitude", coordinatesDTO.getStartLat());
	    coordJsonObject.put("start_longitude", coordinatesDTO.getStartLong());
	    coordJsonObject.put("end_latitude", coordinatesDTO.getEndLat());
	    coordJsonObject.put("end_longitude", coordinatesDTO.getEndLong());
	    
	    HttpEntity<String> requestEntity = new HttpEntity<>(coordJsonObject.toString(), headers);
	    ResponseEntity<String> responseEntity = restTemplate.exchange(locationSimulatorUrl, HttpMethod.POST, requestEntity, String.class);

		return new ResponseEntity<>(
			      "Sent",
			      HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<DonationCenter> updateDonationCenter(@RequestBody DonationCenterDTO newData){
		User user = getCurrentUser();
		DonationCenter newCenter = new DonationCenter(newData);
		donationCenterService.update(newCenter, user.getDonationCenter().getId());
		
		return new ResponseEntity<>(newCenter, HttpStatus.OK);
	}
	
	@GetMapping("/get_score/{id}")
	public ResponseEntity<DonationCenterScoreDTO> getCenterScore(@PathVariable("id") int id) {
		DonationCenterScoreDTO centerScoreDTO = new DonationCenterScoreDTO();
		List<DonationCenterScore> centerScores = donationCenterScoreService.findByCenterId(id);
		for(DonationCenterScore cs: centerScores) {
			if(cs.getUser().getId() == getCurrentUser().getId()) {
				centerScoreDTO.setId(cs.getId());
				centerScoreDTO.setCenterId(id);
				centerScoreDTO.setScore(cs.getScore());
			
			} else {
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		}			
		return new ResponseEntity<>(centerScoreDTO, HttpStatus.OK);	
	}
	
	@PostMapping("/set_score")
	public ResponseEntity<String> setScore(@RequestBody DonationCenterScoreDTO newScore, HttpServletRequest request){
		User user = getCurrentUser();
		DonationCenter center = donationCenterService.findById(newScore.getCenterId());
		DonationCenterScore centerScore = new DonationCenterScore(user, center, newScore.getScore());
		if(reservationService.isUserReservationProcessed(user,  newScore.getCenterId()) == true) {
			donationCenterScoreService.save(centerScore);
			System.out.println("ovde2");
			return new ResponseEntity<>(
				      "Center rated!",
				      HttpStatus.CREATED);}
		else {
			System.out.println("ovde3");
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
	@PutMapping("/update_score")
	public ResponseEntity<DonationCenterScoreDTO> updateScore(@RequestBody DonationCenterScoreDTO updatedScore){
		User user = getCurrentUser();
		DonationCenter center = donationCenterService.findById(updatedScore.getCenterId());
		int savedScore = donationCenterScoreService.update(user, updatedScore);
		DonationCenterScoreDTO newCenter = new DonationCenterScoreDTO(updatedScore.getId(), savedScore, center.getId());
		return new ResponseEntity<>(newCenter, HttpStatus.OK);
	}
	
	@GetMapping("/allAvailable")
	public ResponseEntity<List<DonationCenterDTO>> getAllAvailableCenters(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
		try {
			date = date.plusHours(2);
			List<DonationCenterDTO> donationCenterDtos = donationCenterService.findAvailableCenters(date);
					
			return new ResponseEntity<>(donationCenterDtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/loyaltyProgram")
	public ResponseEntity<LoyaltyProgram> getLoyaltyProgram() {
		try {
			LoyaltyProgram p = loyaltyProgramService.getLoyaltyProgram();
			return new ResponseEntity<>(p, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/loyaltyProgram")
	public ResponseEntity<LoyaltyProgram> updateLoyaltyProgram(@RequestBody LoyaltyProgram loyaltyProgram){
		return new ResponseEntity<>(loyaltyProgramService.update(loyaltyProgram), HttpStatus.OK);
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