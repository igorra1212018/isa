package com.isa.donorapp.service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.google.zxing.EncodeHintType;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.repository.UserRepository;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import com.isa.donorapp.repository.TermRepository;
import com.isa.donorapp.repository.ReservationRepository;

@Service
public class TermService {
	
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private TermRepository termRepository;
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
	
	public List<Term> findVisitedAppointments(Integer userId)
	{
		List<Reservation> reservations = reservationRepository.findByUserId(userId);
		List<Term> visitedTerms = new ArrayList<Term>();
		for (Reservation r : reservations) {
			if (!r.isCanceled() && r.getStatus() == EReservationStatus.PROCESSED) {
				Term term = r.getTerm();
				term.setReservedBy(r.getUser());
				visitedTerms.add(term);
			}
		}
		return visitedTerms;
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
	
	public List<Term> findAll()
	{
		List<Term> terms = termRepository.findAll();
		return terms;
	}
    
	public Term save(Term term)
	{
		return termRepository.save(term);
	}
}
