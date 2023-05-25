package com.isa.donorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.donorapp.model.Blood;
import com.isa.donorapp.model.User;
import com.isa.donorapp.repository.BloodRepository;
import com.isa.donorapp.repository.UserRepository;

@Service
public class BloodService {

	@Autowired
	private BloodRepository bloodRepository;
	
	public Blood findById(Integer id)
	{
		Optional<Blood> foundBlood = bloodRepository.findById(id);
		if(foundBlood.isEmpty())
			return null;
		else
			return foundBlood.get();
	}
	
	public List<Blood> findAll()
	{
		List<Blood> bloods = bloodRepository.findAll();
		return bloods;
	}
}
