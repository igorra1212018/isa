package com.isa.donorapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	private String name;
	
	private Integer quantity;
	
	@ManyToOne
    @JoinColumn(name = "center_id")
	private DonationCenter donationCenter;
	
	public Equipment() {}

	public Equipment(Integer id, String name, Integer quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	
	public Equipment(String name, Integer quantity, DonationCenter donationCenter) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.donationCenter = donationCenter;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public DonationCenter getDonationCenter() {
		return donationCenter;
	}

	public void setDonationCenter(DonationCenter donationCenter) {
		this.donationCenter = donationCenter;
	}
	
}
