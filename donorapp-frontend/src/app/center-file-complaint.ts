import { StaffFileComplaint } from "./staff-file-complaint";

export class CenterFileComplaint {
    id: number;
    name: string;
    staff: StaffFileComplaint[];

    constructor(id: number, name: string, staff: StaffFileComplaint[]) {
        this.id = id;
        this.name = name;
        this.staff = staff;
    }
}