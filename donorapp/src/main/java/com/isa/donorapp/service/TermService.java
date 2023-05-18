package com.isa.donorapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.model.User;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.repository.UserRepository;
import com.isa.donorapp.repository.TermRepository;
import com.isa.donorapp.repository.ReservationRepository;
import com.isa.donorapp.repository.RoleRepository;

@Service
public class TermService {
	
	@Autowired
	private UserService userService;
	
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
			reservationRepository.save(reservation);
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
	
}
