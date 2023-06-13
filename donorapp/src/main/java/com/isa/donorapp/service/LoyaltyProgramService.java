package com.isa.donorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isa.donorapp.model.LoyaltyProgram;
import com.isa.donorapp.repository.LoyaltyProgramRepository;

@Service
public class LoyaltyProgramService {
	@Autowired
	private LoyaltyProgramRepository loyaltyProgramRepository;
	
	public LoyaltyProgram getLoyaltyProgram() {
		return loyaltyProgramRepository.findAll().get(0);
	}
	
	public LoyaltyProgram save(LoyaltyProgram p) {
		return loyaltyProgramRepository.save(p);
	}
	
	public LoyaltyProgram update(LoyaltyProgram p) {
		LoyaltyProgram program = loyaltyProgramRepository.findAll().get(0);
		
		program.setPointsPerDonation(p.getPointsPerDonation());
		program.setCategory1Name(p.getCategory1Name());
		program.setCategory2Name(p.getCategory2Name());
		program.setCategory3Name(p.getCategory3Name());
		program.setCategory1Points(p.getCategory1Points());
		program.setCategory2Points(p.getCategory2Points());
		program.setCategory3Points(p.getCategory3Points());
		
		save(program);
		
		return program;
	}
 }
