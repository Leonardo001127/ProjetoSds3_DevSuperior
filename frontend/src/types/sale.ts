import { Seller } from "./seller"


export type Sale = {
    id: number,
    visited: number,
    amount: number,
    deals: number,
    date: string,
    seller: Seller
}



export type SalePage = {
    content?: Sale[],
    page: number,
    size?: number,
    last?: boolean,
    totalElements?: number,
    totalPages?: number,
    number: number,
    first?: boolean,
    numberOfElements?: number,
    empty?: boolean
}


export type SaleSum = {
    sellerName: string,
    sum: number
}

export type SaleSuccess = {
    sellerName: string,
    visited: number,
    deals: number
}