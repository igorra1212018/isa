package com.isa.donorapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.model.DonationCenterComplaint;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.repository.UserRepository;
import com.isa.donorapp.repository.DonationCenterComplaintRepository;
import com.isa.donorapp.repository.RoleRepository;

@Service
public class DonationCenterComplaintService {
	
	@Autowired
	private DonationCenterComplaintRepository donationCenterComplaintRepository;
	@Autowired
	ReservationService reservationService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public DonationCenterComplaint findById(Integer id)
	{
		Optional<DonationCenterComplaint> foundDonationCenterComplaint = donationCenterComplaintRepository.findById(id);
		if(foundDonationCenterComplaint.isEmpty())
			return null;
		else
			return foundDonationCenterComplaint.get();
	}
	
	public List<DonationCenterComplaint> findByCenterId(Integer centerId)
	{
		List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintRepository.findByCenterId(centerId);
		return donationCenterComplaints;
	}
	
	public List<DonationCenterComplaint> findAll()
	{
		List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintRepository.findAll();
		return donationCenterComplaints;
	}
	
	public DonationCenterComplaint create(DonationCenterComplaint complaint)
	{
		List<Reservation> reservations = reservationService.findByUserId(complaint.getUser().getId());
		boolean visited = false;
		for (Reservation r : reservations) {
			if (r.getTerm().getCenter().getId() == complaint.getCenter().getId() && r.getStatus() == EReservationStatus.PROCESSED) {
				visited = true;
				break;
			}
		}
		if (visited) {
			return donationCenterComplaintRepository.save(complaint);
		}
		return null;
	}
	
    
	public DonationCenterComplaint save(DonationCenterComplaint donationCenterComplaint)
	{
		return donationCenterComplaintRepository.save(donationCenterComplaint);
	}
	/*
	public User getLoggedUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.print(currentUserEmail);
		return userService.findByEmail(currentUserEmail);
	}
	*/
}
