export class DeliveryCoordinates {
    startLat: number;
    startLong: number;
    endLat: number;
    endLong: number;
     
    constructor(startLat: number, startLong: number, endLat: number, endLong: number) {
        this.startLat = startLat;
        this.startLong = startLong;
        this.endLat = endLat;
        this.endLong = endLong;
    }  
}