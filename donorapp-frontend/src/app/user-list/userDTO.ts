export class UserDTO {
    email: string;
    firstName: string;
    lastName: string;
    penalties: Number;

    constructor(email: string, firstName: string, lastName: string, penalties: Number) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.penalties = penalties;
    }
}