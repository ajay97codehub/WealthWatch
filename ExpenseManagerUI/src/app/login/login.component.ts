import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl, FormGroup, FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../services/user.service';
import { response } from 'express';
import { error } from 'console';
import { CommonModule } from '@angular/common';
import { AuthService } from '../services/auth.service';



@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterLink,FormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  providers:  [UserService]
})
export class LoginComponent {
  public IsValid=true;
  public errMsg="Please check form has some empty or null data";
  constructor(private userService:UserService,private router:Router,private auth:AuthService){}
  login(loginForm:NgForm){
    if(this.userService.IsValid(loginForm.value)){
      this.userService.login(loginForm.value).subscribe(
        (response: any)=>{
          console.log(response);
          if(response){
            this.auth.setToken(response.jwtToken);
            this.auth.setUserName(response.username);
            this.router.navigate(['user',response.username]);
          }
        },
        (error: any)=>{
          console.log(error);
        }
      );
    }else{
      this.IsValid=false;
    }
    
  }

}
