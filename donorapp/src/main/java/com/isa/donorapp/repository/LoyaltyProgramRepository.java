package com.isa.donorapp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isa.donorapp.model.LoyaltyProgram;

public interface LoyaltyProgramRepository extends JpaRepository<LoyaltyProgram, Long> {
	Optional<LoyaltyProgram> findById(Integer id);
}
