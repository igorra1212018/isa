export class DonationCenterComplaint {
    id: number;
    centerId: number;
    userId: number;
    text: string;
     
    constructor(id: number, centerId: number, userId: number, text: string) {
        this.id = id;
        this.centerId = centerId;
        this.userId = userId;
        this.text = text;
    }  
}