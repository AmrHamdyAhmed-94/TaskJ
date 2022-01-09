export interface CustomersResponse {
    content: Customer[];
    totalElements: number;
}
export interface Customer{
    id: number;
    name: string;
    phone: string;
    state: string | undefined;
    countryName: string | undefined;
}