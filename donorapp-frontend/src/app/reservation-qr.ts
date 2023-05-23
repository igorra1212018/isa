export class ReservationQR {
    id: number;
    creationDate: Date;
    status: string;
    qrCode: string;
    
    constructor(id: number, creationDate: Date, status: string, qrCode: string) {
        this.id = id
        this.creationDate = creationDate;
        this.status = status;
        this.qrCode = qrCode;
    }  
}