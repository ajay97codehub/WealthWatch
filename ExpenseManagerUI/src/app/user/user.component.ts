import { Component, ViewChild } from '@angular/core';
import { UserService } from '../services/user.service';
import { ActivatedRoute } from '@angular/router';
import { ExpenseComponent } from '../expense/expense.component';
import { CommonModule } from '@angular/common';
import { TransactionComponent } from '../transaction/transaction.component';
import { Transaction, TransactionService } from '../services/transaction.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [ExpenseComponent,CommonModule,TransactionComponent],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  public userName:String="";
  public userId:number;
  public isNewTransaction:boolean=false;
  public userBalance:any=[];
  public currentDate = new Date();
  @ViewChild('transactionComponent') transactionComponent: TransactionComponent;
  constructor(private userService:UserService,private transactionService:TransactionService,private route:ActivatedRoute){}
  ngOnInit(): void {
    this.route.params.subscribe(params => {
    this.userName = params['username'];
    this.userService.getUser(this.userName).subscribe(
      (response: any)=>{
        console.log("ajay");
        console.log(response);
        if(response){
          this.userId=response.userId;
          localStorage.setItem("userId",this.userId.toString());
          this.loadTransactions(this.userId);
        }
      },
      (error: any)=>{
        console.log(error);
      }
    );
});}
handleTransactionAdded() {
  // Refresh the transactions or perform any action needed
  this.loadTransactions(this.userId);
}

loadTransactions(userId:number) {
  // Logic to refresh transactions
  this.userService.getUserBalance(userId).subscribe(
    (balance)=>{
      if(balance){
        this.userBalance = balance;
      }
    }
  );
}

addData(){
  this.isNewTransaction=true;
  console.log("adddata clicked");
}
saveData(){

}
updateData(){

}
editTransaction(transaction:any){
  this.isNewTransaction=false;
  this.transactionService.updateTransaction(transaction.transactionId).subscribe(() => {
    this.loadTransactions(this.userId);
  });
  console.log(transaction);
}
deleteTransaction(transaction:any) {
  this.transactionService.deleteTransaction(transaction.transactionId).subscribe(() => {
    this.loadTransactions(this.userId);
  });
}

}
