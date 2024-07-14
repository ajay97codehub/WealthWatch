import { Component } from '@angular/core';
import { UserService } from '../services/user.service';
import { ActivatedRoute } from '@angular/router';
import { ExpenseComponent } from '../expense/expense.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [ExpenseComponent,CommonModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  public userName:String="";
  public userId:number;
  public isNewTransaction:boolean=false;
  public userBalance:any=[];
  public currentDate = new Date();
  constructor(private userService:UserService,private route:ActivatedRoute){}
  ngOnInit(): void {
    this.route.params.subscribe(params => {
    this.userName = params['username'];
    this.userService.getUser(this.userName).subscribe(
      (response: any)=>{
        console.log("ajay");
        console.log(response);
        if(response){
          this.userId=response.userId;
          this.userService.getUserBalance(this.userId).subscribe(
            (balance)=>{
              console.log(balance);
              if(balance){
                this.userBalance = balance;
              }
            }
          );
        }
      },
      (error: any)=>{
        console.log(error);
      }
    );
});}
addData(){
  this.isNewTransaction=true;
  console.log("adddata clicked");
}
saveData(){

}
updateData(){

}
onEdit(){
  this.isNewTransaction=false;

}

}
