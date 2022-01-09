import { Component } from '@angular/core';
import { ViewChild } from '@angular/core'
import { RestConsumingService } from './services/RestConsuming.service';
import * as paginator from '@angular/material/paginator';
import { tap } from 'rxjs/operators';
import { MatTableDataSource } from '@angular/material/table';
import { Customer, CustomersResponse } from './Classes/GetCustomersResponse';
import { AbstractControl, FormBuilder } from '@angular/forms';
import { CountriesReponse, Country } from './Classes/GetCountriesResponse';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  displayedColumns = ['name', 'phone','countryName' , 'state'];
  customerDatasource= new MatTableDataSource();
  title = 'exercise';
  countriesData: Country[]=[];
  selectedCountryId : number = 0;
  filterSelectOptionsState = [];
  filterSelectOptionsCountryName = [];

  length:number = 0;
  pageSizeOptions = [5, 10, 25, 100];
  pageSize = this.pageSizeOptions[0];
  pageIndex = 0;
  
  readonly formControl: AbstractControl;
  constructor(private restConsumingService : RestConsumingService,formBuilder: FormBuilder ){ 

    this.formControl = formBuilder.group({
      countryName: '',
      state: '',
    })
    this.formControl.valueChanges.subscribe(value => {
      console.log(value);
      const filter = {...value} as string;
      this.customerDatasource.filter = filter;
    });
  }


  ngOnInit(){
    this.restConsumingService.getCountries().subscribe((data : CountriesReponse) => {
      this.countriesData = data.countryList;
    });
    this.getCustomerData();
    this.customerDatasource.filterPredicate = ((data, filter) => {
       const a = !filter.state || data.state === filter.state;
       const b = !filter.countryName || data.countryName === filter.countryName;
      return a && b;
    }) as (PeriodicElement, string) => boolean;
    
  }

  private getCustomerData(){
    this.restConsumingService.getCustomers(this.pageIndex , this.pageSize).subscribe((data : CustomersResponse) => {
      this.length = data.totalElements;
      data.content.forEach(customer=>{
        this.setCountryNameAndStateValue(customer);
      });
      this.customerDatasource.data = data.content;
      this.filterSelectOptionsCountryName = this.getFilterObject(data.content, 'countryName');
      this.filterSelectOptionsState = this.getFilterObject(data.content, 'state');

    });
  }
  private setCountryNameAndStateValue(customr: Customer): void{
    const country = this.countriesData.filter(a => customr.phone.startsWith(`(${a.countryCode})`))[0];
    customr.countryName = country.countryName;
    country.countryRegex = country.countryRegex.replace(/\\\\/g, '\\');
    customr.state = new RegExp(country.countryRegex).test(customr.phone) ? 'Valid' : 'Not-Valid';

    // condattion on cuntry code with cust phone
}
  getFilterObject(fullObj, key) {
    const uniqChk = [];
    fullObj.filter((obj) => {
      if (!uniqChk.includes(obj[key])) {
        uniqChk.push(obj[key]);
      }
      return obj;
    });
    return uniqChk;
  }
  resetFilters() {
    this.formControl.reset();
    this.customerDatasource.filter = "";
  }
  handlePageEvent(event : paginator.PageEvent){
    this.length = event.length;
    this.pageSize = event.pageSize;
    this.pageIndex = event.pageIndex;
    this.getCustomerData();
  }
 
}
