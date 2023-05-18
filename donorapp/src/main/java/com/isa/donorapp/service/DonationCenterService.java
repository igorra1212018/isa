package com.isa.donorapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.DonationCenterScore;
import com.isa.donorapp.repository.UserRepository;
import com.isa.donorapp.repository.DonationCenterRepository;
import com.isa.donorapp.repository.RoleRepository;

@Service
public class DonationCenterService {
	
	@Autowired
	private DonationCenterScoreService donationCenterScoreService;
	
	@Autowired
	private DonationCenterRepository donationCenterRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public DonationCenter findById(Integer id)
	{
		Optional<DonationCenter> foundDonationCenter = donationCenterRepository.findById(id);
		if(foundDonationCenter.isEmpty())
			return null;
		else {
			DonationCenter donationCenter = foundDonationCenter.get();
			donationCenter.setRating(calculateScore(donationCenter.getId()));
			return donationCenter;
		}
	}
	
	public List<DonationCenter> findAll()
	{
		List<DonationCenter> donationCenters = donationCenterRepository.findAll();
		for (DonationCenter dc : donationCenters) {
			dc.setRating(calculateScore(dc.getId()));
		}
		return donationCenters;
	}
    
	public DonationCenter save(DonationCenter donationCenter)
	{
		return donationCenterRepository.save(donationCenter);
	}
	
	private double calculateScore(Integer id) {
		List<DonationCenterScore> scores = donationCenterScoreService.findByCenterId(id);
		double scoreSum = 0;
		for (DonationCenterScore dcs : scores) {
			scoreSum += dcs.getScore();
		}
		if(scores != null && !scores.isEmpty()) {
			return scoreSum / scores.size();
		}
		return 0;
	}
	
	/*
	public User getLoggedUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.print(currentUserEmail);
		return userService.findByEmail(currentUserEmail);
	}
	*/
}
