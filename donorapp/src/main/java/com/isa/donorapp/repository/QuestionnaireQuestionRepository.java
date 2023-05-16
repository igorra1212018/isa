package com.isa.donorapp.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.QuestionnaireQuestion;

public interface QuestionnaireQuestionRepository extends JpaRepository<QuestionnaireQuestion, Long> {
	Optional<QuestionnaireQuestion> findById(Integer id);
}