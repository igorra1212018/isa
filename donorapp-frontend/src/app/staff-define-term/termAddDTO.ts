export class TermAddDTO {
    date: string;
    duration: number;
    centerId: number;

    constructor(date: string, duration: number, centerId: number) {
        this.date = date;
        this.duration = duration;
        this.centerId = centerId;
    }
}
