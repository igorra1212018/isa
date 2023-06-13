package com.isa.donorapp.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Questionnaire {
	@Id
	@SequenceGenerator(name = "questionnaire_sequence_generator", sequenceName = "questionnaire_sequence", initialValue = 100)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="questionnaire_sequence_generator")
	protected Integer id;
	
	private LocalDateTime date;
	
	@OneToOne
    @JoinColumn(name = "user_id")
	User user;
	
	@Transient
	List<QuestionnaireAnswer> answers;

	public Questionnaire() {}

	public Questionnaire(LocalDateTime date, User user, List<QuestionnaireAnswer> answers) {
		this.date = date;
		this.user = user;
		this.answers = answers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<QuestionnaireAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<QuestionnaireAnswer> answers) {
		this.answers = answers;
	}
}
