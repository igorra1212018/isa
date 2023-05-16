package com.isa.donorapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionnaireQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	private String text;
	
	private boolean womanOnly;

	public QuestionnaireQuestion() {}

	public QuestionnaireQuestion(String text, boolean womanOnly) {
		this.text = text;
		this.womanOnly = womanOnly;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isWomanOnly() {
		return womanOnly;
	}

	public void setWomanOnly(boolean womanOnly) {
		this.womanOnly = womanOnly;
	}
}
