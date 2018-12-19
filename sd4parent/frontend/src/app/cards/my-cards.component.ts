import {Component, OnInit, TemplateRef} from '@angular/core';
import {Product} from "../model/product";
import {ProductService} from "../service/product.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AuthService} from "../service/auth.service";
import {AccountProductService} from "../service/account-product.service";
import {Router} from "@angular/router";
import {AccountProduct} from "../model/accountProduct";

@Component({
  selector: 'my-card',
  templateUrl: './my-cards.component.html',
  styleUrls: ['./my-cards.component.css']
})

export class MyCardsComponent implements OnInit {

  public subscriptionPosts: AccountProduct[];
  private subscriptions: Subscription[] = [];
  public left: number[] = [];

  constructor(private accountProductsService: AccountProductService,
              private authService: AuthService, private router: Router) { }

  ngOnInit() {
    if(this.authService.getUsername() != null) {
      this.loadPosts(this.authService.getUsername());
    } else {
      this.router.navigate(['home']);
    }
  }

  private loadPosts(login: string): void {
    this.subscriptions.push(this.accountProductsService.getAccountProductsByLogin(login).subscribe(subs => {
      this.subscriptionPosts = subs as AccountProduct[];
    }))
  }

  public cancelSubscription(subscriptionId: string): void {
    this.subscriptions.push(this.accountProductsService.deleteAccountProduct(subscriptionId).subscribe(() => {
      this.updateSubscriptions();
    }))
  }

  private updateSubscriptions(): void {
    this.loadPosts(this.authService.getUsername());
  }

  /*public _shortDescription(description: string): string {
    let point: number;
    description = description.slice(0,792);
    if(description.length === 220) {
      for(let j: number = 0; j<description.length; j++) {
        if(description[j] === '.')
          point = j+1;
      }
    }
    return description.slice(0,point);
  }
*/
}
