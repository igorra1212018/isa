
export class Question {
    id: number;
    text: string;
    womanOnly: boolean;
    answer: string | null;
    
    constructor(id: number, text: string, womanOnly: boolean, answer: string | null) {
        this.id = id
        this.text = text;
        this.womanOnly = womanOnly;
        this.answer = answer;
    }  
}