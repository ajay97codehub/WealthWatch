import { Component } from '@angular/core';
import { RouterLink ,Router} from '@angular/router';
import { AuthService } from '../services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink,CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  //public IsUserLoggedIn:boolean;
  constructor(public authService:AuthService,private router:Router){}
  public IsAdmin:boolean=false;
  logoutUser(){
    this.authService.clear();
    this.router.navigate(['login']);
  }
  
}
