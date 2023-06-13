package com.isa.donorapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.donorapp.dto.DonationCenterDTO;
import com.isa.donorapp.dto.ProcessesReservationDTO;
import com.isa.donorapp.dto.StaffDTO;
import com.isa.donorapp.dto.StaffQuestionnaireDTO;
import com.isa.donorapp.dto.UserProfileDTO;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.Equipment;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.StaffQuestionnaire;
import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.service.DonationCenterService;
import com.isa.donorapp.service.ReservationService;
import com.isa.donorapp.service.StaffService;
import com.isa.donorapp.service.UserService;

import ch.qos.logback.core.util.ContentTypeUtil;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@Autowired
	UserService userService;
		
	@Autowired
	DonationCenterService donationCenterService;
	
	@Autowired
	ReservationService reservationService;
		
	@GetMapping("/profile")
	public ResponseEntity<UserProfileDTO> getUserProfile() 
	{
		User user = getCurrentUser();
		UserProfileDTO userDTO = new UserProfileDTO(user);
		
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
		
	@PutMapping("/update")
	@Secured("ROLE_STAFF")
	public ResponseEntity<StaffDTO> updateStaffInfo(@RequestBody StaffDTO newData) 
	{
		StaffDTO updatedStaffDTO = new StaffDTO(staffService.updateStaff(newData));

		return new ResponseEntity<>(updatedStaffDTO, HttpStatus.OK);
	}
	
	@PostMapping("/register_staff")
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<User> registerStaff(@RequestBody StaffDTO newStaff)
	{
		User staff = new User(newStaff);
		DonationCenter dc = donationCenterService.findById(newStaff.getCenterId());
		staffService.registerStaff(staff, dc);
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}
		
	@GetMapping("/users")
	@Secured("ROLE_STAFF")
	public ResponseEntity<List<User>> getStaffByCenterId() 
	{
		User user = getCurrentUser();
		List<User> staff = staffService.findStaffFromCenter(user.getDonationCenter().getId());
		if (staff.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(staff, HttpStatus.OK);
		}
	}
	
	@GetMapping("/processed_users")
	@Secured("ROLE_STAFF")
    public ResponseEntity<List<ProcessesReservationDTO>> getProcessedUsers()
    {
        User currentUser = getCurrentUser();
        List<ProcessesReservationDTO> processesReservations = staffService.getProcessedUsersForCenter(
                currentUser.getDonationCenter().getId());
        return new ResponseEntity<>(processesReservations, HttpStatus.OK);
    } 

	@GetMapping("/work_calendar/{parse}")
	@Secured("ROLE_STAFF")
	public ResponseEntity<List<ProcessesReservationDTO>> getNewReservations(@PathVariable("parse") String parse) 
	{
		User currentUser = getCurrentUser();
        List<ProcessesReservationDTO> processesReservations = staffService.getNewReservations(parse, currentUser.getDonationCenter().getId());
        return new ResponseEntity<>(processesReservations, HttpStatus.OK);
	}
	
	@PutMapping("/stood_up/{id}")
	@Secured("ROLE_STAFF")
	public ResponseEntity<String> stoodUpAppointment(@PathVariable Integer id) 
	{
		reservationService.stoodUpAppointment(id);

		return new ResponseEntity<>(
			      "User stood up the appointment!",
			      HttpStatus.OK);
	}	
	
	@PutMapping("/rejected/{id}")
	@Secured("ROLE_STAFF")
	public ResponseEntity<String> reqsNotMetAppointment(@PathVariable Integer id) 
	{
		reservationService.reqsNotMetAppointment(id);

		return new ResponseEntity<>(
			      "Appointment rejected!",
			      HttpStatus.OK);
	}	
	
	@PostMapping("/startAppointment")
	@Secured("ROLE_STAFF")
	public ResponseEntity<String> startAppointment(@RequestBody StaffQuestionnaireDTO sqdto)
	{
		try {
			System.out.println("ovde1");
			User user = getCurrentUser();
			DonationCenter donationCenter = donationCenterService.findById(user.getDonationCenter().getId());
			System.out.println("ovde2");
			StaffQuestionnaire questionnaire = new StaffQuestionnaire(sqdto);
			System.out.println("ovde3");
			Reservation reservation = reservationService.findById(sqdto.getReservationId());
			System.out.println("ovde4");
			List<Equipment> equipment = sqdto.getEquipment();
			System.out.println("ovde5");
			staffService.startAppointment(questionnaire, donationCenter, equipment, reservation);
			
			return new ResponseEntity<>(
				      "Equipment recorded",
				      HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(
				      "Not successful",
				      HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@GetMapping("/equipment")
	@Secured("ROLE_STAFF")
	public ResponseEntity<List<Equipment>> getEquipmentByCenterId() 
	{
		User user = getCurrentUser();
		List<Equipment> equipment = staffService.getEquipmentByCenterId(user.getDonationCenter().getId());
		if (equipment.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(equipment, HttpStatus.OK);
		}
	}
				
	private User getCurrentUser() 
	{
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByEmail(currentUserEmail);
	}
	
}
