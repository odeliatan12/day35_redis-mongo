export interface AccountCreation{
    name: string
    balance: number
}

export interface Account{
    id: string
    name: string
    balance: number
}

export interface AccountTransfer{
    fromAccount: string
    toAccount: string
    transferAmount: number
    comments: string
}