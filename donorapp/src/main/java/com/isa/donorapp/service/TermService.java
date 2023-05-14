package com.isa.donorapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.model.Term;
import com.isa.donorapp.model.User;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.repository.UserRepository;
import com.isa.donorapp.repository.TermRepository;
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
	private RoleRepository roleRepository;
	
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
		List<Term> terms = termRepository.findByReservedById(reservedById);
		return terms;
	}
	
	public List<Term> findUpcomingAppointments(Integer userId)
	{
		List<Term> terms = termRepository.findByReservedById(userId);
		List<Term> upcomingAppointments = new ArrayList<Term>();
		for (Term t : terms) {
			if(t.getDate().isAfter(LocalDateTime.now()))
				upcomingAppointments.add(t);
		}
		return upcomingAppointments;
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
	
	public User getLoggedUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.print(currentUserEmail);
		return userService.findByEmail(currentUserEmail);
	}
	
}
