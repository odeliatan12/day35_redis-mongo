import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { AccountCreation } from "src/app/models";

@Injectable()
export class FundsService{

    constructor(private http: HttpClient){ }

    createNewAccount(funds: AccountCreation): Promise<string>{
        return firstValueFrom(
            this.http.post<string>("http://localhost:8080/newAccount", funds)
        )
    }

}