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
	
	public List<DonationCenterComplaint> findByUserId(Integer userId)
	{
		List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintRepository.findByUserId(userId);
		return donationCenterComplaints;
	}
	
	public List<DonationCenterComplaint> findAll()
	{
		List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintRepository.findAll();
		return donationCenterComplaints;
	}
	
	public List<DonationCenterComplaint> findByNoReply()
	{
		List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintRepository.findByReplyIsNull();
		return donationCenterComplaints;
	}
	
	public List<DonationCenterComplaint> findByReplied()
	{
		List<DonationCenterComplaint> donationCenterComplaints = donationCenterComplaintRepository.findByReplyIsNotNull();
		return donationCenterComplaints;
	}
	
	public DonationCenterComplaint create(DonationCenterComplaint complaint)
	{
		return donationCenterComplaintRepository.save(complaint);
	}
	
    
	public DonationCenterComplaint save(DonationCenterComplaint donationCenterComplaint)
	{
		return donationCenterComplaintRepository.save(donationCenterComplaint);
	}
}
