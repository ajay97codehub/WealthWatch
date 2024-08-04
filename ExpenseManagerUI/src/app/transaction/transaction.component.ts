import { AfterViewInit, Component, ElementRef, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { TransactionService, Transaction } from '../services/transaction.service';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import bootstrap from '../../main.server';

@Component({
  selector: 'app-transaction',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements AfterViewInit{
  transactionForm: FormGroup;
  @Output() transactionAdded = new EventEmitter<void>();
  @Input() IsNewTransaction:boolean;
  @ViewChild('expenseModal') transactionModal: ElementRef;
  private bootstrapModal: any;

  constructor(
    private fb: FormBuilder,
    private transactionService: TransactionService
  ) {
    this.transactionForm = this.fb.group({
      amount: [0, [Validators.required, Validators.min(1)]],
      description: ['', Validators.required],
      date: ['', Validators.required],
      type: ['income', Validators.required]
    });
  }

  ngAfterViewInit() {
    // Initialize Bootstrap Modal
    //this.bootstrapModal = new bootstrap.Modal(this.transactionModal.nativeElement);
  }

  

  closeModal() {
    this.bootstrapModal.hide();
  }

  

  resetForm() {
    this.transactionForm.reset();
  }

  onSubmit(): void {
    if (this.transactionForm.valid) {
      const transaction: Transaction = this.transactionForm.value;
      transaction.userId=Number(localStorage.getItem("userId"));
      if(this.IsNewTransaction){
        this.transactionService.addTransaction(transaction).subscribe({
          next: (data) => {
            console.log('Transaction added successfully', data);
            this.transactionAdded.emit();
            // Reset the form
            //this.resetForm();
            // Close modal and reset form
            //this.closeModal();
          },
          error: (error) => {
            console.error('There was an error!', error);
          }
        });
      }
      
    }
  }
}
