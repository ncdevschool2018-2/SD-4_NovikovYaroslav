import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableComponent } from './table.component';
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {AlertModule, BsDropdownModule, ModalModule, TabsModule} from 'ngx-bootstrap';
import { FormsModule} from '@angular/forms';
import{ProductsComponent} from "../products/products.component";
import {BillingAccountsComponent} from "../billing-accounts/billing-accounts.component";
import { AccordionModule } from 'ngx-bootstrap/accordion';
import { TypeaheadModule } from 'ngx-bootstrap/typeahead';
import { BsDatepickerModule } from 'ngx-bootstrap';

@NgModule({
  imports: [
    FormsModule,
    Ng4LoadingSpinnerModule.forRoot(),
    CommonModule,
    AlertModule.forRoot(),
    TabsModule.forRoot(),
    ModalModule.forRoot(),
    AccordionModule.forRoot(),
    BsDropdownModule.forRoot(),
    TypeaheadModule.forRoot(),
    BsDatepickerModule.forRoot()
  ],
  declarations: [
    TableComponent,
    BillingAccountsComponent,
    ProductsComponent
  ],
  exports: [
    TableComponent
  ]
})
export class TableModule { }
