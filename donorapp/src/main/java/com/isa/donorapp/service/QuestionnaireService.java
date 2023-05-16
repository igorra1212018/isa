package com.isa.donorapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isa.donorapp.model.Questionnaire;
import com.isa.donorapp.model.QuestionnaireAnswer;
import com.isa.donorapp.model.QuestionnaireQuestion;
import com.isa.donorapp.model.User;
import com.isa.donorapp.repository.UserRepository;
import com.isa.donorapp.repository.QuestionnaireAnswerRepository;
import com.isa.donorapp.repository.QuestionnaireQuestionRepository;
import com.isa.donorapp.repository.QuestionnaireRepository;
import com.isa.donorapp.repository.RoleRepository;

@Service
public class QuestionnaireService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	@Autowired
	private QuestionnaireQuestionRepository questionnaireQuestionRepository;
	@Autowired
	private QuestionnaireAnswerRepository questionnaireAnswerRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public Questionnaire findById(Integer id)
	{
		Optional<Questionnaire> foundQuestionnaire = questionnaireRepository.findById(id);
		if(foundQuestionnaire.isEmpty())
			return null;
		else {
			Questionnaire questionnaire = foundQuestionnaire.get();
			List<QuestionnaireAnswer> answers = questionnaireAnswerRepository.findByQuestionnaireId(questionnaire.getId());
			questionnaire.setAnswers(answers);
			return questionnaire;
		}
	}
	
	public Questionnaire findByUserId(Integer userId)
	{
		Optional<Questionnaire> foundQuestionnaire = questionnaireRepository.findByUserId(userId);
		if(foundQuestionnaire.isEmpty())
			return null;
		else {
			return findById(foundQuestionnaire.get().getId());
		}
	}
	
	public List<QuestionnaireQuestion> findQuestionsAll()
	{
		List<QuestionnaireQuestion> questions = questionnaireQuestionRepository.findAll();
		return questions;
	}
	
	public List<Questionnaire> findAll()
	{
		List<Questionnaire> questionnaires = questionnaireRepository.findAll();
		return questionnaires;
	}
	
	public Questionnaire submit(Questionnaire questionnaire)
	{
		Questionnaire ret = questionnaireRepository.save(questionnaire);
		for (QuestionnaireAnswer a : questionnaire.getAnswers()) {
			questionnaireAnswerRepository.save(a);
		}
		return ret;
	}
    
	public Questionnaire save(Questionnaire questionnaire)
	{
		return questionnaireRepository.save(questionnaire);
	}
}
