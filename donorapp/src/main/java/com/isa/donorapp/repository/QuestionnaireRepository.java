package com.isa.donorapp.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
	Optional<Questionnaire> findById(Integer id);
	Optional<Questionnaire> findByUserId(Integer userId);
}