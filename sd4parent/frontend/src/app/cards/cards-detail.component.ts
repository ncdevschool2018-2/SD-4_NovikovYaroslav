import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ProductService} from "../service/product.service";
import {Product} from "../model/product";
import {Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-hero-detail',
  templateUrl: './cards-detail.component.html'
})
export class CardsDetailComponent implements OnInit {
  product: Product;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getProduct();
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
