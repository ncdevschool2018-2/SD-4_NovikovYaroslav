import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SigninModalComponent} from "./signin-modal/signin-modal.component";
import {AdminPageComponent} from "./admin-page/admin-page.component";
import {CarouselComponent} from "./carousel/carousel.component";
import {BillingAccountsComponent} from "./billing-accounts/billing-accounts.component";
import {ProductsComponent} from "./products/products.component";
import {CardsComponent} from "./cards/cards.component";
import {CardsDetailComponent} from "./cards/cards-detail.component";

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: CarouselComponent},
  {path: 'signin', component: SigninModalComponent},
  {path: 'login', component: SigninModalComponent},
  {path: 'admin', component: AdminPageComponent},
  {path: 'accounts', component: BillingAccountsComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'cards', component: CardsComponent},
  {path: 'detail/:id', component: CardsDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
