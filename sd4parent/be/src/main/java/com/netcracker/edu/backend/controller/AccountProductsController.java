package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.AccountProducts;
import com.netcracker.edu.backend.service.AccountProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/account-products")
public class AccountProductsController {
    private AccountProductsService accountProductsService;

    @Autowired
    public AccountProductsController(AccountProductsService accountProductsService) {
        this.accountProductsService = accountProductsService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountProducts> getAccountProductsById(@PathVariable(name = "id") Long id) {
        Optional<AccountProducts> accountProducts = accountProductsService.getAccountProductsById(id);
        if (accountProducts.isPresent()) {
            return ResponseEntity.ok(accountProducts.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<AccountProducts> getAllAccountProducts() {
        return accountProductsService.getAllAccountProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public AccountProducts saveAccountProducts(@RequestBody AccountProducts accountProducts) {
        return accountProductsService.saveAccountProducts(accountProducts);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccountProducts(@PathVariable(name = "id") Long id) {
        accountProductsService.deleteAccountProducts(id);
        return ResponseEntity.noContent().build();
    }

}
