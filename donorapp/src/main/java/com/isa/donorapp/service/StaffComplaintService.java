package com.isa.donorapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.model.StaffComplaint;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.repository.UserRepository;
import com.isa.donorapp.repository.StaffComplaintRepository;
import com.isa.donorapp.repository.RoleRepository;

@Service
public class StaffComplaintService {
	
	@Autowired
	private StaffComplaintRepository staffComplaintRepository;
	@Autowired
	ReservationService reservationService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public StaffComplaint findById(Integer id)
	{
		Optional<StaffComplaint> foundStaffComplaint = staffComplaintRepository.findById(id);
		if(foundStaffComplaint.isEmpty())
			return null;
		else
			return foundStaffComplaint.get();
	}
	
	public List<StaffComplaint> findByStaffId(Integer staffId)
	{
		List<StaffComplaint> staffComplaints = staffComplaintRepository.findByStaffId(staffId);
		return staffComplaints;
	}
	
	public List<StaffComplaint> findAll()
	{
		List<StaffComplaint> staffComplaints = staffComplaintRepository.findAll();
		return staffComplaints;
	}
	
	public StaffComplaint create(StaffComplaint complaint)
	{
		return staffComplaintRepository.save(complaint);
	}
	
    
	public StaffComplaint save(StaffComplaint staffComplaint)
	{
		return staffComplaintRepository.save(staffComplaint);
	}
}
