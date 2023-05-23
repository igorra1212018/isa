package com.isa.donorapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.dto.StaffDTO;
import com.isa.donorapp.dto.UserProfileDTO;
import com.isa.donorapp.model.Location;
import com.isa.donorapp.model.Staff;
import com.isa.donorapp.model.User;
import com.isa.donorapp.repository.RoleRepository;
import com.isa.donorapp.repository.UserRepository;

@Service
public class StaffService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
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
}
