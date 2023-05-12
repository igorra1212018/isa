package com.isa.donorapp.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.isa.donorapp.dto.UserRegisterDTO;
import com.isa.donorapp.model.enums.EGender;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();
	
	boolean activated = false;
	
	private String firstName;
	private String lastName;
	@Embedded
	private Location residence;
	private String phoneNumber;
	private String jmbg;
	
	private EGender gender;
	private String occupation;
	private String occupationInfo;
	
	private int penaltyCount = 0;
	
	//Staff Role
	@ManyToOne
    @JoinColumn(name = "center_id")
	private DonationCenter donationCenter;
	
	public User() {}
	
	public User(String email, String password, Set<Role> roles, boolean activated, String firstName, String lastName,
			Location residence, String phoneNumber, String jmbg, EGender gender, String occupation, String occupationInfo,
			int penaltyCount) {
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.activated = activated;
		this.firstName = firstName;
		this.lastName = lastName;
		this.residence = residence;
		this.phoneNumber = phoneNumber;
		this.jmbg = jmbg;
		this.gender = gender;
		this.occupation = occupation;
		this.occupationInfo = occupationInfo;
		this.penaltyCount = penaltyCount;
	}


	public User(UserRegisterDTO userDTO) {
		this.email = userDTO.getEmail();
		this.password = userDTO.getPassword(); //Enkripcija ovde?
		this.firstName = userDTO.getFirstName();
		this.lastName = userDTO.getLastName();
		this.residence = new Location(userDTO.getAddress(), userDTO.getCity(), userDTO.getCountry(), 0, 0);
		this.phoneNumber = userDTO.getPhoneNumber();
		this.jmbg = userDTO.getJmbg();
		this.gender = EGender.valueOf(userDTO.getGender()); //Treba validacija pre ovoga
		this.occupation = userDTO.getOccupation();
		this.occupationInfo = userDTO.getOccupationInfo();
	}
	
	public Integer getId() {
		return id;
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
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
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
	
	public Location getResidence() {
		return residence;
	}
	
	public void setResidence(Location residence) {
		this.residence = residence;
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

	public EGender getGender() {
		return gender;
	}

	public void setGender(EGender gender) {
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
	
	public DonationCenter getDonationCenter() {
		return donationCenter;
	}

	public void setDonationCenter(DonationCenter donationCenter) {
		this.donationCenter = donationCenter;
	}

	public int getPenaltyCount() {
		return penaltyCount;
	}

	public void setPenaltyCount(int penaltyCount) {
		this.penaltyCount = penaltyCount;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
}