import { ActivatedRoute } from '@angular/router';
import {formatDate, getLocaleDateFormat, Location} from '@angular/common';
import { ProductService} from "../service/product.service";
import {Product} from "../model/product";
import {Component, OnInit} from "@angular/core";
import {User} from "../model/user";
import {Subscription} from "rxjs";
import {UserService} from "../service/user.service";
import {AccountProduct} from "../model/accountProduct";
import {AuthService} from "../service/auth.service";
import {AccountProductService} from "../service/account-product.service";
import {moment} from "ngx-bootstrap/chronos/test/chain";
import {AccountId} from "../model/accountId";
import {Purse} from "../model/purse";
import {PurseService} from "../service/purse.service";

@Component({
  selector: 'app-cards-detail',
  templateUrl: './cards-detail.component.html',
  styleUrls: ['./cards-detail.component.css']
})
export class CardsDetailComponent implements OnInit {
  product: Product;
  private subscriptions: Subscription[] = [];
  private user: User;
  private accountId: AccountId = new AccountId();
  private accountProduct: AccountProduct = new AccountProduct();
  public purse: Purse;

  constructor(
    private userService: UserService,
    private authService: AuthService,
    private accProdService: AccountProductService,
    private route: ActivatedRoute,
    private productService: ProductService,
    private location: Location,
    private purseService: PurseService
  ) {}

  ngOnInit(): void {
    this.getProduct();
    this.loadPurse();
  }

  private _subscribe(): void {
    this.subscriptions.push(this.userService.getUserByLogin(this.authService.getUsername()).subscribe(account => {
      this.user = account as User;
      this.accountId.id = this.user.id;
      this.accountProduct.account = this.accountId;
      this.accountProduct.product = this.product;
      this.accountProduct.dateBeg = moment().format('YYYY-MM-DD');
      this.accountProduct.dateEnd = moment(this.accountProduct.dateBeg).add(this.product.days, 'day').format('YYYY-MM-DD');
      this.accProdService.saveAccountProduct(this.accountProduct).subscribe()
    }))
  }

  getProduct(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.productService.getProductById(id)
      .subscribe(product => this.product = product);
  }

  private loadPurse() {
    this.subscriptions.push(this.userService.getUserByLogin(this.authService.getUsername()).subscribe(account => {
      this._getPurseByOwnerId(account.id);
    }));
  }

  _getPurseByOwnerId(accountId: string) {
    this.subscriptions.push(this.purseService.getPurseByOwnerId(accountId).subscribe( purses => {
      this.purse = purses;
    }));
  }


  goBack(): void {
    this.location.back();
  }
}
