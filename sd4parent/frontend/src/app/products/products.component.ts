import {Component, OnInit, TemplateRef} from '@angular/core';
import {Product} from "../model/product";
import {ProductService} from "../service/product.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'product-tables',
  templateUrl: './products.component.html'
})
export class ProductsComponent implements OnInit {

  public editMode = false;

  public products: Product[];
  public editablePr: Product = new Product();
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  private subscriptions: Subscription[] = [];


  // Dependency injection for BillingAccountService into Billing
  constructor(private productService: ProductService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) { //to show the modal, we also need the ngx-bootstrap service
  }

  // Calls on component init
  ngOnInit() {
    this.loadProducts();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, product: Product): void {

    if (product) {
      this.editMode = true;
      this.editablePr = Product.cloneBase(product);
    } else {
      this.refreshPr();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _addProduct(): void {
    this.loadingService.show();
    this.subscriptions.push(this.productService.saveProduct(this.editablePr).subscribe(() => {
      this._updateProducts();
      this.refreshPr();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateProducts(): void {
    this.loadProducts();
  }

  public _deleteProduct(productId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.productService.deleteProduct(productId).subscribe(() => {
      this._updateProducts();
    }));
  }

  private refreshPr(): void {
    this.editablePr = new Product();
  }

  private loadProducts(): void {
    this.loadingService.show();
    // Get data from ProductService
    this.subscriptions.push(this.productService.getProducts().subscribe(products => {
      // Parse json response into local array
      this.products = products as Product[];
      // Check data in console
      console.log(this.products);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
