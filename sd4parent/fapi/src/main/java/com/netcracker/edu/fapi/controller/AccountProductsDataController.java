package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.AccountProductsViewModel;
import com.netcracker.edu.fapi.service.AccountProductsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ap")
public class AccountProductsDataController {

    @Autowired
    private AccountProductsDataService accountProductsDataService;

    @RequestMapping
    public ResponseEntity<List<AccountProductsViewModel>> getAllAccountProducts() {
        return ResponseEntity.ok(accountProductsDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountProductsViewModel> saveAccountProducts(@RequestBody AccountProductsViewModel accountProducts /*todo server validation*/) {
        if (accountProducts != null) {
            return ResponseEntity.ok(accountProductsDataService.saveAccountProducts(accountProducts));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAccountProducts(@PathVariable String id) {
        accountProductsDataService.deleteAccountProducts(Long.valueOf(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<AccountProductsViewModel>> getAccountProductsByUserId(@RequestParam("login") String login) {
        return ResponseEntity.ok(accountProductsDataService.getAccountProductsByUserId(login));
    }

}
