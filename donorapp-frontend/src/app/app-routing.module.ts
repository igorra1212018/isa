import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import { UserUpcomingAppointmentsComponent } from './user-upcoming-appointments/user-upcoming-appointments.component';
import { UserQuestionnaireComponent } from './user-questionnaire/user-questionnaire.component';
import { UserDonationCenterComponent } from './user-donation-center/user-donation-center.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserQrCodesComponent } from './user-qr-codes/user-qr-codes.component';
import { AuthGuard } from './auth.guard';
import { Role } from './role';
import { UserAppointmentHistoryComponent } from './user-appointment-history/user-appointment-history.component';
import { StaffProfileComponent } from './staff-profile/staff-profile.component';
import { AdminDonationCenterComponent } from './admin-donation-center/admin-donation-center.component';
import { StaffHomepageComponent } from './staff-homepage/staff-homepage.component';
import { StaffDonationCenterComponent } from './staff-donation-center/staff-donation-center.component';
import { StaffEditDonationCenterComponent } from './staff-edit-donation-center/staff-edit-donation-center.component';
import { StaffBloodViewComponent } from './staff-blood-view/staff-blood-view.component';
import { HomeComponent } from './home/home.component';
import { UserFileComplaintComponent } from './user-file-complaint/user-file-complaint.component';
import { UserComplaintsComponent } from './user-complaints/user-complaints.component';

const routes: Routes = [
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent},
  { path: "", component: HomeComponent},
  { path: "user-homepage", component: UserHomepageComponent, canActivate: [AuthGuard]},
  { path: "user-upcoming-appointments", component: UserUpcomingAppointmentsComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: "user-questionnaire", component: UserQuestionnaireComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: 'user-profile', component: UserProfileComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: "user-donation-center/:id", component: UserDonationCenterComponent },
  { path: "user-qr-codes", component: UserQrCodesComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: "user-appointment-history", component: UserAppointmentHistoryComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: "user-file-complaint/:id", component: UserFileComplaintComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: "user-complaints", component: UserComplaintsComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: "staff-profile", component: StaffProfileComponent, data: { roles: [Role.Staff]}},
  { path: "staff-homepage", component: StaffHomepageComponent},
  { path: "staff-donation-center/:id", component: StaffDonationCenterComponent},
  { path: "staff-edit-donation-center/:id", component: StaffEditDonationCenterComponent},
  { path: "admin-donation-center", component: AdminDonationCenterComponent, canActivate: [AuthGuard], data: { roles: [Role.Admin]}},
  { path: "staff-bloodview", component: StaffBloodViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
