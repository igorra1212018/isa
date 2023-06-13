package com.isa.donorapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DonationCenterScore {
	@Id
	@SequenceGenerator(name = "center_score_sequence_generator", sequenceName = "center_score_sequence", initialValue = 100)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="center_score_sequence_generator")
	protected Integer id;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	User user;
	
	@ManyToOne
    @JoinColumn(name = "center_id")
	DonationCenter center;
	int score;
	
	public DonationCenterScore() {}
	
	public DonationCenterScore(User user, DonationCenter center, int score) {
		this.user = user;
		this.center = center;
		this.score = score;
	}	
	
	public Integer getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public DonationCenter getCenter() {
		return center;
	}
	public void setCenter(DonationCenter center) {
		this.center = center;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
