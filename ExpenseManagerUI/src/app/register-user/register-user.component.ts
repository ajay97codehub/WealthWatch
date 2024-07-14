import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register-user',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './register-user.component.html',
  styleUrl: './register-user.component.css'
})
export class RegisterUserComponent {
  constructor(private userService:UserService,private router:Router){}
  registerNewUser(createUser:NgForm){
    
    console.log(createUser.value);
    this.userService.registerNewUser(createUser.value).subscribe(
      (response)=>{
        console.log(response);
        this.router.navigate(['login']);
      },
    (error)=>{
      console.log(error);
    }
    )
  }
}
