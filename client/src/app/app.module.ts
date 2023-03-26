import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FundsComponent } from './components/funds/funds.component';
import { FundsService } from './components/funds/funds.service';
import { AccountTransferComponent } from './components/account-transfer/account-transfer.component';
import { AccTransSvc } from './components/account-transfer/account-transfer.service';

@NgModule({
  declarations: [
    AppComponent,
    FundsComponent,
    AccountTransferComponent
  ],
  imports: [
    BrowserModule, FormsModule,
    ReactiveFormsModule, HttpClientModule
  ],
  providers: [ FundsService, AccTransSvc ],
  bootstrap: [AppComponent]
})
export class AppModule { }
