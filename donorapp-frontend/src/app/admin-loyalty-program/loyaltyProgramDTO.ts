export class LoyaltyProgramDTO {
    id: number = 0;
    pointsPerDonation: number;
    category1Name: string;
    category1Points: number;
    category2Name: string;
    category2Points: number;
    category3Name: string;
    category3Points: number;

    constructor(ppd: number, cat1n: string, cat1p: number, cat2n: string, cat2p: number, cat3n: string, cat3p: number) {
        this.pointsPerDonation = ppd;
        this.category1Name = cat1n;
        this.category1Points = cat1p;
        this.category2Name = cat2n;
        this.category2Points = cat2p;
        this.category3Name = cat3n;
        this.category3Points = cat3p;
    }
}