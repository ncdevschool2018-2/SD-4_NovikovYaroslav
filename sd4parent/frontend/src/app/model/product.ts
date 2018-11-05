export class Product {
  id: string;
  title: string;
  cost: string;
  days: string;
  description: string;
  pictures: string;

  static cloneBase(product: Product): Product {
    let clonedProduct: Product = new Product();
    clonedProduct.id = product.id;
    clonedProduct.title = product.title;
    clonedProduct.cost = product.cost;
    clonedProduct.days = product.days;
    clonedProduct.description = product.description;
    clonedProduct.pictures = product.pictures;
    return clonedProduct;
  }
}
