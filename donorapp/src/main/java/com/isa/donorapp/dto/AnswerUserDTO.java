package com.isa.donorapp.dto;

import com.isa.donorapp.model.QuestionnaireAnswer;

public class AnswerUserDTO {
	private Integer questionId;
	private boolean answer;
	
	public AnswerUserDTO() {}

	public AnswerUserDTO(Integer questionId, boolean answer) {
		this.questionId = questionId;
		this.answer = answer;
	}
	
	public AnswerUserDTO(QuestionnaireAnswer answer) {
		this.questionId = answer.getQuestion().getId();
		this.answer = answer.isAnswer();
	}
	
	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
}
