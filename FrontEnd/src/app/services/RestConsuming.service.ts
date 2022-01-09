import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/internal/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

const getCountriesEndpoint = 'getallcountries';
const getCustomersEndPoint = 'getallcustomers';

@Injectable({
  providedIn: 'root'
})
export class RestConsumingService {

  constructor(private http: HttpClient) { }

  getCountries(): Observable<any> {
    return this.http.get(environment.apiUrl+getCountriesEndpoint).pipe(
      map(this.extractData),
      catchError(this.handleError)
    );
  }

  getCustomers(page : number , size : number): Observable<any> {
    return this.http.get(environment.apiUrl+getCustomersEndPoint+`?page=${page}&size=${size}`).pipe(
      map(this.extractData),
      catchError(this.handleError)
    );
  }

  private extractData(res: Response): any {
    const body = res;   
    return body || { };
  }

  private handleError(error: HttpErrorResponse): any {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }
}
