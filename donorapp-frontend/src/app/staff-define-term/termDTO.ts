export class TermDTO {
    date: Date;
    duration: number;
    centerId: number;

    constructor(date: Date, duration: number, centerId: number) {
        this.date = new Date(date);
        this.duration = duration;
        this.centerId = centerId;
    }
}
