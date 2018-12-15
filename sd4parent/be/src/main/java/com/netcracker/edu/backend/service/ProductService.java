package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    Optional<Product> getProductById(Long id);
    Iterable<Product> getAllProducts();
    void deleteProduct(Long id);
/*    Page<Product> getProductsByPage(int page);*/
}
