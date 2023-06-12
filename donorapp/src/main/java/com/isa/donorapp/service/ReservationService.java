package com.isa.donorapp.service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.google.zxing.EncodeHintType;
import com.isa.donorapp.event.OnRegistrationCompleteEvent;
import com.isa.donorapp.event.OnReservationCompleteEvent;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.repository.UserRepository;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import com.isa.donorapp.repository.ReservationRepository;
import com.isa.donorapp.repository.RoleRepository;

@Service
public class ReservationService {
	
	@Autowired
	private TermService termService;
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public Reservation findById(Integer id)
	{
		Optional<Reservation> foundReservation = reservationRepository.findById(id);
		if(foundReservation.isEmpty())
			return null;
		else
			return foundReservation.get();
	}
	
	public List<Reservation> findByUserId(Integer id) {
		List<Reservation> foundReservations = reservationRepository.findByUserId(id);
		List<Reservation> reservations = new ArrayList<Reservation>();
		for (Reservation r : foundReservations) {
			if (!r.isCanceled()) {
				reservations.add(r);
			}
		}
		return reservations;
	}
	
	public Reservation reserveTerm(Integer termId, Integer userId)
	{
		Term term = termService.findById(termId);
		if (term != null) {
			User currentUser = userService.findById(userId);
			List<Reservation> termReservations = reservationRepository.findByTermId(termId);
			for (Reservation r : termReservations) {
				if (r.getUser().getId() == userId && !r.isCanceled()) {
					return null;
				}
			}
			Reservation reservation = new Reservation(currentUser, term, LocalDateTime.now(), false, EReservationStatus.NEW);
			String reservationInfoText = generateReservationInfo(reservation);
			
			ByteArrayOutputStream outputStream = QRCode.from(reservationInfoText)
												.withHint(EncodeHintType.CHARACTER_SET, "UTF-8").to(ImageType.PNG).stream();
			byte[] qrCodeBytes = outputStream.toByteArray();
			reservation.setQrCode(qrCodeBytes);
			String qrCodeBase64 = Base64Utils.encodeToString(qrCodeBytes);
			reservationRepository.save(reservation);
			
			eventPublisher.publishEvent(new OnReservationCompleteEvent(currentUser, qrCodeBase64));
			/*
			try {
				emailService.sendEmailWithQRCode(currentUser.getEmail(), qrCodeBase64);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			*/
			return reservation;
		}
		return null;
	}
	
	private String generateReservationInfo(Reservation reservation)
	{
		Term term = reservation.getTerm();
		LocalDateTime creationDate = reservation.getCreationDate();
		String reservationInfo = "Id: " + term.getId() + "\n";
		reservationInfo += "Creation date: " + creationDate.getDayOfMonth() + "." + creationDate.getMonthValue() + "." + creationDate.getYear() + ".\n";
		reservationInfo += "Creation time: " + creationDate.getHour() + ":" + creationDate.getMinute() + "\n";
		reservationInfo += "Donation Center: " + term.getCenter().getName() + "\n";
		DonationCenter center = term.getCenter();
		reservationInfo += "Address: " + center.getAddress().getAddress() + ", " + center.getAddress().getCity() + "\n";
		LocalDateTime date = term.getDate();
		reservationInfo += "Date: " + date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear() + ".\n";
		reservationInfo += "Time: " + date.getHour() + ":" + date.getMinute() + "\n";
		reservationInfo += "Duration: " + term.getDuration() + " minutes"; 
		return reservationInfo;
	}
	
	public boolean cancelReservation(Integer termId, Integer userId) {
		List<Reservation> termReservations = reservationRepository.findByTermId(termId);
		Reservation reservation = null;
		for (Reservation r : termReservations) {
			if (r.getUser().getId() == userId) {
				reservation = r;
				break;
			}
		}
		if (reservation != null) {
			if (LocalDateTime.now().isAfter(reservation.getTerm().getDate().minusDays(1)))
				return false;
			if (reservation.isCanceled())
				return false;
			reservation.setCanceled(true);
			reservationRepository.save(reservation);
			return true;
		}
		return false;
	}
	
	public boolean isUserReservationProcessed(User user, int centerId) 
	{	
		System.out.println(user.getId());
		System.out.println(centerId);
		boolean check = true;
		List<Reservation> userReservations = reservationRepository.findByUserId(user.getId());
		System.out.println(userReservations);
		System.out.println(userReservations.isEmpty());
		if(userReservations.isEmpty() == false) {
			for(Reservation r: userReservations) {
				System.out.println(r.getId());
				Term t = termService.findById(r.getTerm().getId());
				System.out.println(t.getId());
				if(t.getCenter().getId() == centerId && r.getStatus() == EReservationStatus.PROCESSED) {
					check = true;;
				}else
					check = false;
			}
		}else {
			check = false;
		}
		System.out.println(check);
		return check;
	}

	public void stoodUpAppointment(Integer reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId).get();
		User user = userService.findById(reservation.getUser().getId());
		user.setPenaltyCount(user.getPenaltyCount() + 1);
		userService.updateUser(user);
		reservation.setStatus(EReservationStatus.STOOD_UP);
		reservationRepository.save(reservation);
	}

	public void reqsNotMetAppointment(Integer reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId).get();
		reservation.setStatus(EReservationStatus.REJECTED);
		reservationRepository.save(reservation);		
	}
}
