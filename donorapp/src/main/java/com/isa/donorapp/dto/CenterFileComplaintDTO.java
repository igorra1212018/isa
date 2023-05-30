package com.isa.donorapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.User;

public class CenterFileComplaintDTO {
	Integer id;
	String name;
	List<StaffFileComplaintDTO> staff;
	
	public CenterFileComplaintDTO() {}
	
	public CenterFileComplaintDTO(Integer id, String name, List<StaffFileComplaintDTO> staff) {
		this.id = id;
		this.name = name;
		this.staff = staff;
	}
	
	public CenterFileComplaintDTO(DonationCenter center, List<User> staff) {
		this.id = center.getId();
		this.name = center.getName();
		this.staff = new ArrayList<StaffFileComplaintDTO>();
		for (User s : staff) {
			StaffFileComplaintDTO staffDTO = new StaffFileComplaintDTO(s);
			this.staff.add(staffDTO);
		}
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

	public List<StaffFileComplaintDTO> getStaff() {
		return staff;
	}

	public void setStaff(List<StaffFileComplaintDTO> staff) {
		this.staff = staff;
	}
}
