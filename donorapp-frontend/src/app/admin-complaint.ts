export class AdminComplaint {
    name: string;
    text: string;
    reply: string;
    userFullName: string;
     
    constructor(name: string, text: string, reply: string, userFullName: string) {
        this.name = name;
        this.text = text;
        this.reply = reply;
        this.userFullName = userFullName;
    }  
}