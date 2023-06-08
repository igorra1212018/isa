package com.isa.donorapp.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.isa.donorapp.dto.AnswerUserDTO;
import com.isa.donorapp.dto.AppointmentDTO;
import com.isa.donorapp.dto.QuestionnaireUserDTO;
import com.isa.donorapp.dto.ReservationQRDTO;
import com.isa.donorapp.dto.TermAddDTO;
import com.isa.donorapp.dto.TermDTO;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.model.Questionnaire;
import com.isa.donorapp.model.QuestionnaireAnswer;
import com.isa.donorapp.model.QuestionnaireQuestion;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.isa.donorapp.model.enums.EGender;
import com.isa.donorapp.model.enums.ERole;
import com.isa.donorapp.service.DonationCenterService;
import com.isa.donorapp.service.ReservationService;
import com.isa.donorapp.service.TermService;
import com.isa.donorapp.service.UserDetailsServiceImpl;
import com.isa.donorapp.service.UserService;

@RestController
@RequestMapping("/api/term")
public class TermController {
	@Autowired
	TermService termService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	UserService userService;
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	DonationCenterService donationCenterService;
	
	
	@GetMapping("/upcoming")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<AppointmentDTO>> getUpcomingAppointments() {
		try {
			User currentUser = getCurrentUser();
			List<Term> terms = termService.findUpcomingAppointments(currentUser.getId());
			List<AppointmentDTO> appointmentDtos = new ArrayList<AppointmentDTO>();
			for (Term t : terms) {
				appointmentDtos.add(new AppointmentDTO(t));
			}
			return new ResponseEntity<>(appointmentDtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/center/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<AppointmentDTO>> getFreeTermsByCenter(@PathVariable("id") int id) {
		try {
			User currentUser = getCurrentUser();
			List<Term> terms = termService.findFreeTermsByCenterId(id, currentUser.getId());
			List<AppointmentDTO> appointmentDtos = new ArrayList<AppointmentDTO>();
			for (Term t : terms) {
				appointmentDtos.add(new AppointmentDTO(t));
			}
			return new ResponseEntity<>(appointmentDtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/center/date/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<TermDTO>> getFreeTermsByCenterForDate(@PathVariable("id") int id, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
		try {
			List<TermDTO> terms = termService.findFreeTermsByCenterIdForDate(id, date);
			
			return new ResponseEntity<>(terms, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/center/addTerm")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> addTerm(@RequestBody TermAddDTO termDTO){
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime date = LocalDateTime.parse(termDTO.getDate(), formatter);
			Term term = new Term(date, termDTO.getDuration());
			term.setCenter(donationCenterService.findById(termDTO.getCenterId()));
			
			if (!termService.checkIfOverlapExists(term)) {
				termService.addTerm(term);	
				return new ResponseEntity<>("Term successfully added!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Failed to add term (overlap detected)!", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
		} catch(Exception e) {
			return new ResponseEntity<>("Failed to add term!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/qr-codes")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<ReservationQRDTO>> getAllQRReservations() {
		try {
			User currentUser = getCurrentUser();
			List<Reservation> reservations = reservationService.findByUserId(currentUser.getId());
			List<ReservationQRDTO> reservationQRDtos = new ArrayList<ReservationQRDTO>();
			for (Reservation r : reservations) {
				reservationQRDtos.add(new ReservationQRDTO(r));
			}
			return new ResponseEntity<>(reservationQRDtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/visited")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<AppointmentDTO>> getVisitedAppointments() {
		try {
			User currentUser = getCurrentUser();
			List<Term> terms = termService.findVisitedAppointments(currentUser.getId());
			List<AppointmentDTO> appointmentDtos = new ArrayList<AppointmentDTO>();
			for (Term t : terms) {
				appointmentDtos.add(new AppointmentDTO(t));
			}
			return new ResponseEntity<>(appointmentDtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/reserve/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> reserve(@PathVariable("id") int id)
	{
		try {
			User currentUser = getCurrentUser();
			if (reservationService.reserveTerm(id, currentUser.getId()) != null)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/cancel/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> cancel(@PathVariable("id") int id)
	{
		try {
			User currentUser = getCurrentUser();
			if (reservationService.cancelReservation(id, currentUser.getId()))
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Treba DTO
	/*
	@GetMapping("/{id}")
	public ResponseEntity<Term> getTermById(@PathVariable("id") Integer id) {
		Term termData = termService.findById(id);
		if (termData != null) {
			return new ResponseEntity<>(termData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	*/
	private User getCurrentUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByEmail(currentUserEmail);
	}
}