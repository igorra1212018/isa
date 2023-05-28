package com.isa.donorapp.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.Role;
import com.isa.donorapp.model.enums.ERole;
public interface DonationCenterRepository extends JpaRepository<DonationCenter, Long> {
	Optional<DonationCenter> findById(Integer id);
	Optional<DonationCenter> findByName(String name);
}