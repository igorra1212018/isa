export class UserComplaint {
    name: string;
    text: string;
    reply: string;
     
    constructor(name: string, text: string, reply: string) {
        this.name = name;
        this.text = text;
        this.reply = reply;
    }  
}