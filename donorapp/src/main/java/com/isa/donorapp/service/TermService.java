package com.isa.donorapp.service;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.google.zxing.EncodeHintType;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.model.User;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.repository.UserRepository;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import com.isa.donorapp.repository.TermRepository;
import com.isa.donorapp.repository.ReservationRepository;
import com.isa.donorapp.repository.RoleRepository;

@Service
public class TermService {
	
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private TermRepository termRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	
	public Term findById(Integer id)
	{
		Optional<Term> foundTerm = termRepository.findById(id);
		if(foundTerm.isEmpty())
			return null;
		else
			return foundTerm.get();
	}
	
	public List<Term> findByReservedById(Integer reservedById)
	{
		List<Reservation> reservations = reservationRepository.findByUserId(reservedById);
		List<Term> terms = new ArrayList<Term>();
		for (Reservation r : reservations) {
			if (!r.isCanceled()) {
				Term term = r.getTerm();
				term.setReservedBy(r.getUser());
				terms.add(term);
			}
		}
		return terms;
	}
	
	public List<Term> findUpcomingAppointments(Integer userId)
	{
		List<Term> terms = findByReservedById(userId);
		List<Term> upcomingAppointments = new ArrayList<Term>();
		for (Term t : terms) {
			if(t.getDate().isAfter(LocalDateTime.now()))
				upcomingAppointments.add(t);
		}
		return upcomingAppointments;
	}
	
	public List<Term> findFreeTermsByCenterId(Integer centerId, Integer userId)
	{
		List<Term> terms = termRepository.findByCenterId(centerId);
		List<Term> freeTerms = new ArrayList<Term>();
		for (Term t : terms) {
			if(t.getDate().isAfter(LocalDateTime.now())) {
				List<Reservation> termReservations = reservationRepository.findByTermId(t.getId());
				boolean found = false;
				for (Reservation r : termReservations) {
					if (!r.isCanceled() || r.getUser().getId() == userId) {
						found = true;
						break;
					}
				}
				if (!found)
					freeTerms.add(t);
			}
		}
		return freeTerms;
	}
	
	public Term reserveTerm(Integer termId, Integer userId)
	{
		Term term = findById(termId);
		if(term != null) {
			User currentUser = userService.findById(userId);
			List<Reservation> termReservations = reservationRepository.findByTermId(termId);
			for (Reservation r : termReservations) {
				if (r.getUser().getId() == userId && !r.isCanceled()) {
					return null;
				}
			}
			Reservation reservation = new Reservation(currentUser, term, false);
			String reservationInfoText = generateReservationInfo(term);
			
			ByteArrayOutputStream outputStream = QRCode.from(reservationInfoText)
												.withHint(EncodeHintType.CHARACTER_SET, "UTF-8").to(ImageType.PNG).stream();
			byte[] qrCodeBytes = outputStream.toByteArray();
			reservation.setQrCode(qrCodeBytes);
			String qrCodeBase64 = Base64Utils.encodeToString(qrCodeBytes);
			reservationRepository.save(reservation);
			
			try {
				emailService.sendEmailWithQRCode(currentUser.getEmail(), qrCodeBase64);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return term;
		}
		return null;
	}
	
	public List<Term> findAll()
	{
		List<Term> terms = termRepository.findAll();
		return terms;
	}
    
	public Term save(Term term)
	{
		return termRepository.save(term);
	}
	
	private String generateReservationInfo(Term term)
	{
		String reservationInfo = "Donation Center: " + term.getCenter().getName() + "\n";
		DonationCenter center = term.getCenter();
		reservationInfo += "Address: " + center.getAddress().getAddress() + ", " + center.getAddress().getCity() + "\n";
		LocalDateTime date = term.getDate();
		reservationInfo += "Date: " + date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear() + ".\n";
		reservationInfo += "Time: " + date.getHour() + ":" + date.getMinute() + "\n";
		reservationInfo += "Duration: " + term.getDuration() + " minutes"; 
		return reservationInfo;
	}
	
}
