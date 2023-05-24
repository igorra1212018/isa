
export class UserHomepageInfo {
    email: string;
    firstName: string;
    lastName: string;
    penaltyCount: number;
    
    constructor(email: string, firstName: string, lastName: string, penaltyCount: number) {
        this.email = email
        this.firstName = firstName;
        this.lastName = lastName;
        this.penaltyCount = penaltyCount;
    }  
}