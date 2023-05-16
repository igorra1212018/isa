import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserQuestionnaire } from './user-questionnaire';
import { Question } from './question';

@Injectable({
  providedIn: 'root'
})
export class UserQuestionnaireService {
  constructor(private http: HttpClient) { }

  getMyQuestionnaire() : Observable<UserQuestionnaire>{
    return this.http.get<UserQuestionnaire>("/api/questionnaire/my_questionnaire");
  }

  getQuestions() : Observable<Question[]>{
    return this.http.get<Question[]>("/api/questionnaire/questions");
  }

  httpOptions = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };
  
  submit(userQuestionnaire: UserQuestionnaire): Observable<string> {
    return this.http.post('/api/questionnaire/my_questionnaire', JSON.stringify(userQuestionnaire), {
      ...this.httpOptions,
      responseType: 'text'
    });
  }
}
