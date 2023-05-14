import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import { UserUpcomingAppointmentsComponent } from './user-upcoming-appointments/user-upcoming-appointments.component';

const routes: Routes = [
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent },
  { path: "user-homepage", component: UserHomepageComponent},
  { path: "user-upcoming-appointments", component: UserUpcomingAppointmentsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
