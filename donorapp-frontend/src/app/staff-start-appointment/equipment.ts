export class Equipment {
    id: number = 0;
    name: string;
    quantity: number = 0;

    constructor(id: number,quantity: number, name: string) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
    }  
}