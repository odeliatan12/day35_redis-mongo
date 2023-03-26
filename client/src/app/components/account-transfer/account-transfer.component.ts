import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Account, AccountTransfer } from 'src/app/models';
import { AccTransSvc } from './account-transfer.service';

@Component({
  selector: 'app-account-transfer',
  templateUrl: './account-transfer.component.html',
  styleUrls: ['./account-transfer.component.css']
})
export class AccountTransferComponent implements OnInit {

  form!: FormGroup
  account: Account[] = []


  constructor(private fb: FormBuilder, private accTransSvc: AccTransSvc){ }

  ngOnInit(): void {

    this.getAllAccounts()
      .then(result => {
      console.log(">>>>> result" + result)
      return this.account = result as Account[]
    })

    this.form = this.createTransferAcc()
      
  }

  getAllAccounts(): Promise<Account[]>{
    return this.accTransSvc.getAllAccount()
  }

  createTransferAcc(){
    return this.fb.group({
      fromAccount: this.fb.control<string>("", [ Validators.required]),
      toAccount: this.fb.control<string>("", [ Validators.required]),
      transferAmount : this.fb.control<number>(10, [ Validators.min(10)]),
      comments: this.fb.control<string>("")
    });
  }

  placeTransfer(): void{
    const values = this.form.value as AccountTransfer
    console.log(values.comments + values.fromAccount)
    this.accTransSvc.postAccTransfer(values)
  }

}
