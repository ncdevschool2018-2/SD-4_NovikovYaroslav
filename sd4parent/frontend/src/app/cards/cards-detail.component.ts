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

@Component({
  selector: 'app-cards-detail',
  templateUrl: './cards-detail.component.html'
})
export class CardsDetailComponent implements OnInit {
  product: Product;
  private subscriptions: Subscription[] = [];
  private user: User;
  private accountProduct: AccountProduct = new AccountProduct();

  constructor(
    private userService: UserService,
    private authService: AuthService,
    private accProdService: AccountProductService,
    private route: ActivatedRoute,
    private productService: ProductService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getProduct();
  }

  private _subscribe(): void {
    this.subscriptions.push(this.userService.getUserByLogin(this.authService.getUsername()).subscribe(account => {
      this.user = account as User;
      this.accountProduct.idAcc = this.user.id;
      this.accountProduct.idPr = this.product.id;
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


  goBack(): void {
    this.location.back();
  }
}
