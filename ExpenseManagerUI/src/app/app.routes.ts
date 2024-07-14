import { Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';

export const routes: Routes = [
    {path:"user/:username",component:UserComponent},
    {path:"login",component:LoginComponent},
    {path:"admin",component:AdminComponent},
    {path:"register",component:RegisterUserComponent},
    {path:"accessdenied",component:ForbiddenComponent},
    {path:"",component:LoginComponent},

];
