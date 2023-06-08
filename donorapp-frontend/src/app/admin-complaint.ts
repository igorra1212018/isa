export class AdminComplaint {
    id: number;
    type: string;
    name: string;
    text: string;
    reply: string;
    userFullName: string;
     
    constructor(id: number, type: string, name: string, text: string, reply: string, userFullName: string) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.text = text;
        this.reply = reply;
        this.userFullName = userFullName;
    }  
}