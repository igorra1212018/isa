package com.isa.donorapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.dto.DonationCenterDTO;
import com.isa.donorapp.dto.TermDTO;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.DonationCenterScore;
import com.isa.donorapp.model.Location;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.repository.UserRepository;
import com.isa.donorapp.repository.DonationCenterRepository;
import com.isa.donorapp.repository.RoleRepository;

@Service
public class DonationCenterService {
	
	@Autowired
	private DonationCenterScoreService donationCenterScoreService;
	@Autowired
	private ReservationService reservationService;
	
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
	
	public DonationCenter findByName(String name)
	{
		Optional<DonationCenter> foundDonationCenter = donationCenterRepository.findByName(name);
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
	
	public DonationCenter update(DonationCenter updatedDonationCenter, int staffId) 
	{
		DonationCenter donationCenter = findById(staffId);
		donationCenter.setName(updatedDonationCenter.getName());
		donationCenter.setAddress(new Location(updatedDonationCenter.getAddress().getAddress(), updatedDonationCenter.getAddress().getCity(), updatedDonationCenter.getAddress().getCountry(), updatedDonationCenter.getAddress().getLatitude(), updatedDonationCenter.getAddress().getLongitude()));
		donationCenter.setDescription(updatedDonationCenter.getDescription());
				
		donationCenterRepository.save(donationCenter);
		return donationCenter;
	}
	
	private double calculateScore(Integer id) 
	{
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

	public boolean hasFreeTerm(Integer id, LocalDateTime date) {
		for (Reservation r: reservationService.findByCenterId(id)) {
			if ((date.isAfter(r.getTerm().getDate().minusSeconds(1)) && date.isBefore(r.getTerm().getDate().plusMinutes(r.getTerm().getDuration()))) ||
				 (date.plusMinutes(30).isAfter(r.getTerm().getDate().minusSeconds(1)) && date.plusMinutes(30).isBefore(r.getTerm().getDate().plusMinutes(r.getTerm().getDuration())) )) {
				return false;
			}
		}
		
		return true;
	}

	public List<DonationCenterDTO> findAvailableCenters(LocalDateTime date) {
		List<DonationCenter> donationCenters = findAll();
		List<DonationCenterDTO> result = new ArrayList<DonationCenterDTO>();
		
		for (DonationCenter c: donationCenters) {
			if (hasFreeTerm(c.getId(), date))
				result.add(new DonationCenterDTO(c));
		}
		
		return result;
	}
	
	
	
	/*
	public User getLoggedUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.print(currentUserEmail);
		return userService.findByEmail(currentUserEmail);
	}
	*/
}
