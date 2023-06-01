export class StaffComplaintCreate {
    staffId: number;
    text: string;
     
    constructor(staffId: number, text: string) {
        this.staffId = staffId;
        this.text = text;
    }  
}