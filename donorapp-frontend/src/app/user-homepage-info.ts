
export class UserHomepageInfo {
    email: string;
    firstName: string;
    lastName: string;
    penaltyCount: number;
    loyaltyPoints: number;
    
    constructor(email: string, firstName: string, lastName: string, penaltyCount: number, loyaltyPoints: number) {
        this.email = email
        this.firstName = firstName;
        this.lastName = lastName;
        this.penaltyCount = penaltyCount;
        this.loyaltyPoints = loyaltyPoints;
    }  
}