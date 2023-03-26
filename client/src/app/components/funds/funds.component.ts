import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AccountCreation } from 'src/app/models';
import { FundsService } from './funds.service';

@Component({
  selector: 'app-funds',
  templateUrl: './funds.component.html',
  styleUrls: ['./funds.component.css']
})
export class FundsComponent implements OnInit{

  form!: FormGroup

  constructor(private fb: FormBuilder, private fundsSvc: FundsService){ }

  ngOnInit(): void {

    this.form = this.createFormNewAccount()
      
  }

  createFormNewAccount(){
    return this.fb.group({
      name: this.fb.control<string>('', [ Validators.required, Validators.min(5) ]),
      balance: this.fb.control<number>( 10, [ Validators.required, Validators.min(10) ])
    })
  }

  createNewAccount(){
    const formValue = this.form.value as AccountCreation
    console.log( formValue.balance )
    console.log(">>>>>> formValue" + formValue)
    this.fundsSvc.createNewAccount(formValue)
  }

}
