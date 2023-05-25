package com.isa.donorapp.model;

import javax.persistence.Embeddable;


@Embeddable
public class Location {
	private final String address;
	private final String city;
	private String country;
	
	private final double latitude;
	private final double longitude;
	
	public Location() {
		this.address = "";
		this.city = "";
		this.country = "";
		this.latitude = 0;
		this.longitude = 0;
	}
	
	public Location(String address, String city, String country) {
		this.address = address;
		this.city = city;
		this.country = country;
		this.latitude = 0;
		this.longitude = 0;
	}
	
	public Location(String address, String city, String country, double latitude, double longtitude) {
		this.address = address;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longtitude;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "Location [address=" + address + ", city=" + city + ", country=" + country + ", latitude=" + latitude
				+ ", longtitude=" + longitude + "]";
	}
}
