package com.isa.donorapp.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.DonationCenterComplaint;
public interface DonationCenterComplaintRepository extends JpaRepository<DonationCenterComplaint, Long> {
	Optional<DonationCenterComplaint> findById(Integer id);
	List<DonationCenterComplaint> findByUserId(Integer userId);
	List<DonationCenterComplaint> findByCenterId(Integer centerId);
	List<DonationCenterComplaint> findByReplyIsNull();
	List<DonationCenterComplaint> findByReplyIsNotNull();
}