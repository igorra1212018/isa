import { UserRegister } from "./register/user-register";

export class ProcessedUser {
    id: number;
    date: Date;
    duration: number;
    user: UserRegister;
    
    constructor(id: number, date: Date, duration: number, user: UserRegister) {
        this.id = id
        this.date = new Date(date);
        this.duration = duration;
        this.user = user;
    }  
}