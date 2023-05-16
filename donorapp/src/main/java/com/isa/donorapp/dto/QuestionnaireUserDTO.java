package com.isa.donorapp.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.isa.donorapp.model.Questionnaire;
import com.isa.donorapp.model.QuestionnaireAnswer;

public class QuestionnaireUserDTO {
	private LocalDateTime date;
	
	private List<AnswerUserDTO> answers;
	
	public QuestionnaireUserDTO() {}

	public QuestionnaireUserDTO(LocalDateTime date, List<AnswerUserDTO> answers) {
		this.date = date;
		this.answers = answers;
	}
	
	public QuestionnaireUserDTO(Questionnaire questionnaire) {
		this.date = questionnaire.getDate();
		this.answers = new ArrayList<AnswerUserDTO>();
		for (QuestionnaireAnswer a : questionnaire.getAnswers()) {
			this.answers.add(new AnswerUserDTO(a));
		}
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public List<AnswerUserDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerUserDTO> answers) {
		this.answers = answers;
	}
}
