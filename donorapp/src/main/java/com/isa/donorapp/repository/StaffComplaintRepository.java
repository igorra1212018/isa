package com.isa.donorapp.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.StaffComplaint;
public interface StaffComplaintRepository extends JpaRepository<StaffComplaint, Long> {
	Optional<StaffComplaint> findById(Integer id);
	List<StaffComplaint> findByUserId(Integer userId);
	List<StaffComplaint> findByStaffId(Integer staffId);
}