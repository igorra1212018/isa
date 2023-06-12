package com.isa.donorapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
	Optional<Equipment> findById(Integer id);

}
