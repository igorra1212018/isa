package com.isa.donorapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.isa.donorapp.dto.AnswerUserDTO;

@Entity
public class QuestionnaireAnswer {
	@Id
	@SequenceGenerator(name = "questionnaire_answer_sequence_generator", sequenceName = "questionnaire_answer_sequence", initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="questionnaire_answer_sequence_generator")
	protected Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    private QuestionnaireQuestion question;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Questionnaire questionnaire;
	
	private boolean answer;

	public QuestionnaireAnswer() {}

	public QuestionnaireAnswer(QuestionnaireQuestion question, Questionnaire questionnaire, boolean answer) {
		this.question = question;
		this.questionnaire = questionnaire;
		this.answer = answer;
	}
	
	public QuestionnaireAnswer(Questionnaire questionnaire, QuestionnaireQuestion question, AnswerUserDTO answerDto) {
		this.questionnaire = questionnaire;
		this.answer = answerDto.isAnswer();
		this.question = question;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QuestionnaireQuestion getQuestion() {
		return question;
	}

	public void setQuestion(QuestionnaireQuestion question) {
		this.question = question;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
}
