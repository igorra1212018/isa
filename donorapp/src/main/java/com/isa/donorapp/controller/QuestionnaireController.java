package com.isa.donorapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.isa.donorapp.dto.AnswerUserDTO;
import com.isa.donorapp.dto.DonationCenterDTO;
import com.isa.donorapp.dto.QuestionnaireUserDTO;
import com.isa.donorapp.dto.UserRegisterDTO;
import com.isa.donorapp.event.OnRegistrationCompleteEvent;
import com.isa.donorapp.model.DonationCenter;
import com.isa.donorapp.model.Questionnaire;
import com.isa.donorapp.model.QuestionnaireAnswer;
import com.isa.donorapp.model.QuestionnaireQuestion;
import com.isa.donorapp.model.Role;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.EGender;
import com.isa.donorapp.model.enums.ERole;
import com.isa.donorapp.service.QuestionnaireService;
import com.isa.donorapp.service.UserDetailsServiceImpl;
import com.isa.donorapp.service.UserService;

@RestController
@RequestMapping("/api/questionnaire")
public class QuestionnaireController {
	@Autowired
	QuestionnaireService questionnaireService;
	@Autowired
	UserService userService;
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@GetMapping("/my_questionnaire")
	@Secured("ROLE_USER")
	public ResponseEntity<QuestionnaireUserDTO> getQuestionnaireByUserId() {
		User currentUser = getCurrentUser();
		Questionnaire questionnaireData = questionnaireService.findByUserId(currentUser.getId());
		if (questionnaireData != null) {
			QuestionnaireUserDTO questionnaireDto = new QuestionnaireUserDTO(questionnaireData);
			return new ResponseEntity<>(questionnaireDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/questions")
	@Secured("ROLE_USER")
	public ResponseEntity<List<QuestionnaireQuestion>> getQuestions() {
		try {
			User currentUser = getCurrentUser();
			List<QuestionnaireQuestion> questions = questionnaireService.findQuestionsAll();
			List<QuestionnaireQuestion> userQuestions = new ArrayList<QuestionnaireQuestion>();
			for (QuestionnaireQuestion q : questions) {
				if (currentUser.getGender() == EGender.FEMALE || !q.isWomanOnly())
					userQuestions.add(q);
			}
			return new ResponseEntity<>(userQuestions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/my_questionnaire")
	@Secured("ROLE_USER")
	public ResponseEntity<String> submitQuestionnaire(@RequestBody QuestionnaireUserDTO questionnaireDto, HttpServletRequest request)
	{
		User currentUser = getCurrentUser();
		Questionnaire oldQuestionnaire = questionnaireService.findByUserId(currentUser.getId());
		Questionnaire newQuestionnaire = new Questionnaire();
		if (oldQuestionnaire != null)
			newQuestionnaire.setId(oldQuestionnaire.getId());
		
		List<QuestionnaireQuestion> questions = questionnaireService.findQuestionsAll();
		List<QuestionnaireAnswer> newAnswers = new ArrayList<QuestionnaireAnswer>();
		
		for (QuestionnaireQuestion q : questions) {
			if (currentUser.getGender() == EGender.FEMALE || !q.isWomanOnly()) {
				boolean found = false;
				for (AnswerUserDTO a : questionnaireDto.getAnswers()) {
					if (a.getQuestionId() == q.getId()) {
						newAnswers.add(new QuestionnaireAnswer(newQuestionnaire, q, a));
						found = true;
						break;
					}
				}
				if (!found) {
					return ResponseEntity
							.badRequest()
							.body("Not all questions answered!");
				}
			}
		}
		if (oldQuestionnaire != null)
			for (QuestionnaireAnswer aNew : newAnswers) {
				for (QuestionnaireAnswer aOld : oldQuestionnaire.getAnswers()) {
					if (aNew.getQuestion().getId() == aOld.getQuestion().getId()) {
						aNew.setId(aOld.getId());
						break;
					}
				}
			}
		
		newQuestionnaire.setAnswers(newAnswers);
		newQuestionnaire.setDate(questionnaireDto.getDate());
		newQuestionnaire.setUser(currentUser);
		
		questionnaireService.submit(newQuestionnaire);
		return new ResponseEntity<>(
			      "Submit successful!", 
			      HttpStatus.OK);
	}
	
	private User getCurrentUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByEmail(currentUserEmail);
	}
}