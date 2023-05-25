package com.isa.donorapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.isa.donorapp.model.enums.EBloodType;
import com.isa.donorapp.model.enums.EGender;

@Entity
@Table(name = "blood_table")
public class Blood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	private EBloodType type;
	private double quantity;
	
	public Blood() {}	
	
	public Blood(EBloodType type, double quantity) {
		super();
		this.type = type;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}
	public EBloodType getType() {
		return type;
	}
	public void setType(EBloodType type) {
		this.type = type;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
}
