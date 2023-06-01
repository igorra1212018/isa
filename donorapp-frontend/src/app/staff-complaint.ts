export class StaffComplaint {
    id: number;
    staffId: number;
    staffFirstName: string;
    staffLastName: string;
    userId: number;
    userFirstName: string;
    userLastName: string;
    text: string;
    reply: string;
     
    constructor(id: number, staffId: number, staffFirstName: string, staffLastName: string, userId: number, userFirstName: string,
                userLastName: string, text: string, reply: string) {
        this.id = id;
        this.staffId = staffId;
        this.staffFirstName = staffFirstName;
        this.staffLastName = staffLastName;
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.text = text;
        this.reply = reply;
    }  
}