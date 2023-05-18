import { DonationCenter } from "./donation-center";

export class Term {
    id: number;
    date: Date;
    duration: number;
    center: DonationCenter;
    
    constructor(id: number, date: Date, duration: number, center: DonationCenter) {
        this.id = id
        this.date = new Date(date);
        this.duration = duration;
        this.center = center;
    }  
}