import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminPageComponent} from "./admin-page/admin-page.component";
import {CarouselComponent} from "./carousel/carousel.component";
import {BillingAccountsComponent} from "./billing-accounts/billing-accounts.component";
import {ProductsComponent} from "./products/products.component";
import {CardsComponent} from "./cards/cards.component";
import {CardsDetailComponent} from "./cards/cards-detail.component";
import {PurseComponent} from "./purse/purse.component";

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: CarouselComponent},
  {path: 'admin', component: AdminPageComponent},
  {path: 'accounts', component: BillingAccountsComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'cards', component: CardsComponent},
  {path: 'cards/:id', component: CardsDetailComponent },
  {path: 'purse', component: PurseComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
