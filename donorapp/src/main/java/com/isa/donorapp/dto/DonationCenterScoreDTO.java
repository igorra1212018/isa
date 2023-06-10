package com.isa.donorapp.dto;

import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.User;

public class DonationCenterScoreDTO {
	protected Integer id;
	int score;
	int centerId;
		
	public DonationCenterScoreDTO() {}

	public DonationCenterScoreDTO(Integer id, int score, int centerId) {
		super();
		this.id = id;
		this.score = score;
		this.centerId = centerId;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
}
