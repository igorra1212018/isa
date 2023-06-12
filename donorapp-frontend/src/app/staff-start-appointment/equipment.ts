export class Equipment {
    name: String = "";
    quantity: number = 0;

    constructor(quantity: number, name: String) {
        this.quantity = quantity;
        this.name = name;
    }  
}