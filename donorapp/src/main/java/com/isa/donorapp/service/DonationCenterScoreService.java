package com.isa.donorapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.model.DonationCenterScore;
import com.isa.donorapp.repository.UserRepository;
import com.isa.donorapp.repository.DonationCenterScoreRepository;
import com.isa.donorapp.repository.RoleRepository;

@Service
public class DonationCenterScoreService {
	
	@Autowired
	private DonationCenterScoreRepository donationCenterScoreRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public DonationCenterScore findById(Integer id)
	{
		Optional<DonationCenterScore> foundDonationCenterScore = donationCenterScoreRepository.findById(id);
		if(foundDonationCenterScore.isEmpty())
			return null;
		else
			return foundDonationCenterScore.get();
	}
	
	public List<DonationCenterScore> findByCenterId(Integer centerId)
	{
		List<DonationCenterScore> donationCenterScores = donationCenterScoreRepository.findByCenterId(centerId);
		return donationCenterScores;
	}
	
	public List<DonationCenterScore> findAll()
	{
		List<DonationCenterScore> donationCenterScores = donationCenterScoreRepository.findAll();
		return donationCenterScores;
	}
    
	public DonationCenterScore save(DonationCenterScore donationCenterScore)
	{
		return donationCenterScoreRepository.save(donationCenterScore);
	}
	/*
	public User getLoggedUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.print(currentUserEmail);
		return userService.findByEmail(currentUserEmail);
	}
	*/
}
