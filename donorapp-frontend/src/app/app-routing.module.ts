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

const routes: Routes = [
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent},
  { path: "", component: UserHomepageComponent, canActivate: [AuthGuard]},
  { path: "user-upcoming-appointments", component: UserUpcomingAppointmentsComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: "user-questionnaire", component: UserQuestionnaireComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: 'user-profile', component: UserProfileComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } },
  { path: "user-donation-center/:id", component: UserDonationCenterComponent },
  { path: "user-qr-codes", component: UserQrCodesComponent, canActivate: [AuthGuard], data: { roles: [Role.User] } }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
