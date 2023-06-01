export class DonationCenterComplaint {
    id: number;
    centerId: number;
    centerName: string;
    userId: number;
    userFirstName: string;
    userLastName: string;
    text: string;
    reply: string;
     
    constructor(id: number, centerId: number, centerName: string, userId: number, userFirstName: string, userLastName: string,
                text: string, reply: string) {
        this.id = id;
        this.centerId = centerId;
        this.centerName = centerName;
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.text = text;
        this.reply = reply;
    }  
}