import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { Account, AccountTransfer } from "src/app/models";

@Injectable()
export class AccTransSvc{

    constructor(private http: HttpClient){ }

    getAllAccount(): Promise<Account[]> {
        return firstValueFrom(
            this.http.get<Account[]>("http://localhost:8080/allAccounts", {responseType: 'json'})
        )
    }

    postAccTransfer(accTrans: AccountTransfer): Promise<string> {
        return firstValueFrom(
            this.http.post<string>("http://localhost:8080/transferAccount", accTrans)
        )
    }
}