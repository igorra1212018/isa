export class Answer {
    questionId: number;
    answer: boolean;
    
    constructor(questionId: number, answer: boolean) {
        this.questionId = questionId;
        this.answer = answer;
    }  
}