package com.isa.donorapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.dto.DonationCenterDTO;
import com.isa.donorapp.dto.ProcessesReservationDTO;
import com.isa.donorapp.dto.StaffDTO;
import com.isa.donorapp.dto.UserProfileDTO;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.Location;
import com.isa.donorapp.model.Reservation;
import com.isa.donorapp.model.Role;
import com.isa.donorapp.model.Staff;
import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.EReservationStatus;
import com.isa.donorapp.model.enums.ERole;
import com.isa.donorapp.repository.RoleRepository;
import com.isa.donorapp.repository.UserRepository;

@Service
public class StaffService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	ReservationService reservationService;
	@Autowired
	TermService termService;
	@Autowired
	private PasswordEncoder encoder;
	
	public User findByEmail(String email)
	{
		Optional<User> foundUser = userRepository.findByEmail(email);
		if(foundUser.isEmpty())
			return null;
		else
			return foundUser.get();
	}
	
	public User updateStaff(StaffDTO newData) {
		User user = findByEmail(newData.getEmail());
		
		user.setPassword(encoder.encode(newData.getPassword()));
		//user.setPassword(newData.getPassword());
		user.setEmail(newData.getEmail());
		user.setFirstName(newData.getFirstName());
		user.setLastName(newData.getLastName());
		user.setResidence(new Location(newData.getAddress(), newData.getCity(), newData.getCountry()));
		user.setOccupation(newData.getOccupation());
		user.setOccupationInfo(newData.getOccupationInfo());
		
		userRepository.save(user);
		
		return user;
	}
	
	public List<User> findByCenterId(Integer centerId)
	{
		return userRepository.findByDonationCenterId(centerId);
	}
	
	public User registerStaff(User newStaff, DonationCenter dc)
	{
		User staff = newStaff;
		staff.setPassword(encoder.encode(newStaff.getPassword()));
		Role staffRole = roleRepository.findByName(ERole.STAFF)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		staff.getRoles().add(staffRole);
		staff.setActivated(true);
		staff.setDonationCenter(dc);
		return userRepository.save(staff);
	}
	
	public List<ProcessesReservationDTO> getProcessedUsers()
	{
		List<ProcessesReservationDTO> dto = new ArrayList<>();
		List<User> allUsers = userRepository.findAll();
		for(User u: allUsers) {
			List<Reservation> allReservations = reservationService.findByUserId(u.getId());
			for(Reservation r: allReservations) {
				if(r.getStatus() == EReservationStatus.PROCESSED) {
					dto.add(new ProcessesReservationDTO(u, termService.findById(r.getTerm().getId())));
				}
				else
				{
					continue;
				}
			}
		}
		return dto;
	}
	
	public List<User> findStaffFromCenter(int Center_id)
	{
		List<User> staffs = userRepository.findByDonationCenterId(Center_id);
		return staffs;
	}
		
}
