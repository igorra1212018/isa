package com.isa.donorapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.StaffQuestionnaire;

public interface StaffQuestionnaireRepository extends JpaRepository<StaffQuestionnaire, Long> {
	Optional<StaffQuestionnaire> findById(Integer id);
}
