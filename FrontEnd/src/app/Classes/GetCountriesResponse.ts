
export interface CountriesReponse{
    statusCode : number,
    errorMsg : string,
    countryList : Country[]
}
export interface Country{
    id:number,
    countryName : string,
    countryCode : string,
    countryRegex : any,
}