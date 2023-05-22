import { Component } from '@angular/core';
import { Question } from '../question';
import { UserQuestionnaireService } from '../services/user-questionnaire.service';
import { Router } from '@angular/router';
import { UserQuestionnaire } from '../user-questionnaire';
import { Answer } from '../answer';

@Component({
  selector: 'app-user-questionnaire',
  templateUrl: './user-questionnaire.component.html',
  styleUrls: ['./user-questionnaire.component.css']
})
export class UserQuestionnaireComponent {
  public questions = [] as Question[];
  questionnaire = new UserQuestionnaire(new Date(), []) as UserQuestionnaire;
  errorMsg = "";

  constructor(private router: Router, private _userQustionnaireService: UserQuestionnaireService) { }
  
  ngOnInit(): void {
    this._userQustionnaireService.getQuestions().subscribe(data => {
      for(var i = 0; i < data.length; i++){
        let question = new Question(data[i].id, data[i].text, data[i].womanOnly, null);
        this.questions.push(question);
      }
      this._userQustionnaireService.getMyQuestionnaire().subscribe(data => {
        if(data != null){
          this.questionnaire = data;
          this.fillAnswers();
        }
      },
      error => {
        this.fillAnswers();
        console.log(this.questions);
      });
    },
      error => this.errorMsg = "Couldn't load questions");
  }

  fillAnswers() {
    for(var i = 0; i < this.questions.length; i++){
      let question = this.questions[i];
      var found = false;
      for(var j = 0; j < this.questionnaire.answers.length; j++){
        let answer = this.questionnaire.answers[j];
        if(answer.questionId == question.id){
          question.answer = String(answer.answer);
          found = true;
          break;
        }
      }
      if(!found){
        question.answer = null;
      }
    }
  }

  printQuestions() {
    console.log(this.questions);
  }

  submitQuestionnaire() {
    console.log("pressed");
    this.questionnaire.answers = [];
    this.questionnaire.date = new Date();
    for(var i = 0; i < this.questions.length; i++){
      var question = this.questions[i];
      if(question.answer == 'true' || question.answer == 'false'){
        let answer = new Answer(question.id, JSON.parse(question.answer));
        this.questionnaire.answers.push(answer);
      }
    }
    console.log(this.questionnaire);
    this._userQustionnaireService.submit(this.questionnaire).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error.error);
      });
  }

  questionnaireIsValid() {
    var valid = true;
    for(var i = 0; i < this.questions.length; i++){
      if(this.questions[i].answer == null){
        valid = false;
        break;
      }
    }
    return valid;
  }
}
