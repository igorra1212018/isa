package com.isa.donorapp.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.DonationCenterScore;
public interface DonationCenterScoreRepository extends JpaRepository<DonationCenterScore, Long> {
	Optional<DonationCenterScore> findById(Integer id);
	List<DonationCenterScore> findByCenterId(Integer centerId);
}