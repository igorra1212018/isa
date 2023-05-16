package com.isa.donorapp.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.QuestionnaireAnswer;

public interface QuestionnaireAnswerRepository extends JpaRepository<QuestionnaireAnswer, Long> {
	Optional<QuestionnaireAnswer> findById(Integer id);
	List<QuestionnaireAnswer> findByQuestionnaireId(Integer questionnaireId);
}