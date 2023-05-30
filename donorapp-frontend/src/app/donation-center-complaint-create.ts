export class DonationCenterComplaintCreate {
    centerId: number;
    text: string;
     
    constructor(centerId: number, text: string) {
        this.centerId = centerId;
        this.text = text;
    }  
}