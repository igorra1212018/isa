package com.isa.donorapp.dto;

import com.isa.donorapp.model.DonationCenter;

public class DonationCenterDTO {
	Integer id;
	String name;
	String city;
	String country;
	String address;
	String description;
	
	double blood_a;
	double blood_b;
	double blood_ab;
	double blood_o;
	double latitude;
	double longitude;
	double rating;
	
	boolean canComplain = false;
	
	public DonationCenterDTO() {}

	public DonationCenterDTO(Integer id, String name, String city, String country, String address, String description,
			double latitude, double longitude, double rating) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
		this.address = address;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
	}
	
	public DonationCenterDTO(DonationCenter donationCenter) {
		this.id = donationCenter.getId();
		this.name = donationCenter.getName();
		this.city = donationCenter.getAddress().getCity();
		this.country = donationCenter.getAddress().getCountry();
		this.address = donationCenter.getAddress().getAddress();
		this.description = donationCenter.getDescription();
		this.latitude = donationCenter.getAddress().getLatitude();
		this.longitude = donationCenter.getAddress().getLongitude();
		this.rating = donationCenter.getRating();
		this.blood_a = donationCenter.getBlood_A();
		this.blood_b = donationCenter.getBlood_B();
		this.blood_ab = donationCenter.getBlood_AB();
		this.blood_o = donationCenter.getBlood_O();
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isCanComplain() {
		return canComplain;
	}

	public void setCanComplain(boolean canComplain) {
		this.canComplain = canComplain;
	}

	public double getBlood_a() {
		return blood_a;
	}

	public void setBlood_a(double blood_a) {
		this.blood_a = blood_a;
	}

	public double getBlood_b() {
		return blood_b;
	}

	public void setBlood_b(double blood_b) {
		this.blood_b = blood_b;
	}

	public double getBlood_ab() {
		return blood_ab;
	}

	public void setBlood_ab(double blood_ab) {
		this.blood_ab = blood_ab;
	}

	public double getBlood_o() {
		return blood_o;
	}

	public void setBlood_o(double blood_o) {
		this.blood_o = blood_o;
	}
}