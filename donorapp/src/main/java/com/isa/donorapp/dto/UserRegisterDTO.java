package com.isa.donorapp.dto;

public class UserRegisterDTO {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String country;
	private String phoneNumber;
	private String jmbg;
	private String gender;
	private String occupation;
	private String occupationInfo;
	
	public UserRegisterDTO() {}
	
	public UserRegisterDTO(String email, String password, String firstName, String lastName, String address,
			String city, String country, String phoneNumber, String jmbg, String gender, String occupation, String occupationInfo) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.jmbg = jmbg;
		this.gender = gender;
		this.occupation = occupation;
		this.occupationInfo = occupationInfo;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getOccupationInfo() {
		return occupationInfo;
	}

	public void setOccupationInfo(String occupationInfo) {
		this.occupationInfo = occupationInfo;
	}
	
}
