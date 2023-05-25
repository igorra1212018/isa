package com.isa.donorapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.Blood;

public interface BloodRepository extends JpaRepository<Blood, Long> {
	Optional<Blood> findById(Integer id);
}
