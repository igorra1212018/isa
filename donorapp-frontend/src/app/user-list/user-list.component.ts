import { Component } from '@angular/core';
import { UserDTO } from './userDTO';
import { UserProfileService } from '../services/user-profile.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {
  users: UserDTO[] = [];
  usersSearchResult: UserDTO[] = [];
  errorMsg: string = '';
  searchField: string = '';

  constructor(private _userProfileService: UserProfileService) { }

  ngOnInit(): void {
    this.fetchUsers();
  }

  searchUsers() {
    this.usersSearchResult = [...this.users]
    if (this.searchField.trim() !== '') {
        this.usersSearchResult = this.usersSearchResult.filter(
            (user) =>
                user.firstName.toLowerCase().includes(this.searchField.toLowerCase()) ||
                user.lastName.toLowerCase().includes(this.searchField.toLowerCase())
        );
    }
}

  fetchUsers(): void {
    this._userProfileService.getAllUsers().subscribe(
      (data: UserDTO[]) => {
        this.users = data;
        this.usersSearchResult = data;
      },
      (error: any) => {
        this.errorMsg = 'Failed to fetch users.';
      }
    );
  }
}
