import { Answer } from "./answer";

export class UserQuestionnaire {
    date: Date;
    answers: Answer[];
    
    constructor(date: Date, answers: Answer[]) {
        this.date = new Date(date);
        this.answers = answers;
    }  
}