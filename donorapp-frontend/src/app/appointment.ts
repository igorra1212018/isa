import { DonationCenter } from "./donation-center";

export class Appointment {
    id: number;
    date: Date;
    duration: number;
    reservationDate: Date;
    center: DonationCenter;
    
    constructor(id: number, date: Date, duration: number, reservationDate: Date, center: DonationCenter) {
        this.id = id
        this.date = new Date(date);
        this.duration = duration;
        this.reservationDate = reservationDate;
        this.center = center;
    }  
}