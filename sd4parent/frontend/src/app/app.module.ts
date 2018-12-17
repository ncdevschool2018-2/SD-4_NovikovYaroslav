import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import { FormsModule }   from '@angular/forms';
import { CarouselModule } from "ngx-bootstrap/carousel";
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { BillingAccountsComponent } from './billing-accounts/billing-accounts.component';
import {ProductsComponent} from "./products/products.component";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {NavbarComponent} from "./navbar/navbar.component";
import {SigninModalComponent} from "./signin-modal/signin-modal.component";
import {ChatComponent} from "./chat/chat.component";
import {CarouselComponent} from "./carousel/carousel.component";
import {TableComponent} from "./table/table.component";
import {CollapseModule} from "ngx-bootstrap";
import {CardsComponent} from "./cards/cards.component";
import {AppRoutingModule} from "./app-routing.module";
import {AdminPageComponent} from "./admin-page/admin-page.component";
import {CardsDetailComponent} from "./cards/cards-detail.component";
import {AlertModule} from 'ngx-bootstrap/alert';
import {TokenStorage} from "./service/token.storage";
import {Interceptor} from "./service/interceptor.service";
import {PurseComponent} from "./purse/purse.component";

@NgModule({
  declarations: [
    AppComponent,
    BillingAccountsComponent,
    ProductsComponent,
    NavbarComponent,
    SigninModalComponent,
    ChatComponent,
    CarouselComponent,
    CardsComponent,
    AdminPageComponent,
    CardsDetailComponent,
    PurseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    AppRoutingModule,
    AlertModule.forRoot(),
    CarouselModule.forRoot(),
    CollapseModule.forRoot()
  ],
  providers: [
    Interceptor,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi: true
    },
    TokenStorage
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
