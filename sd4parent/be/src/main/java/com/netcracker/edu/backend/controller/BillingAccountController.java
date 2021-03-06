package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/billing-accounts")
public class BillingAccountController {

    private BillingAccountService billingAccountService;

    @Autowired
    public BillingAccountController(BillingAccountService billingAccountService) {
        this.billingAccountService = billingAccountService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BillingAccount> getBillingAccountById(@PathVariable(name = "id") Long id) {
        Optional<BillingAccount> billingAccount = billingAccountService.getBillingAccountById(id);
        if (billingAccount.isPresent()) {
            return ResponseEntity.ok(billingAccount.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<BillingAccount> getAllBillingAcounts() {
        return billingAccountService.getAllBillingAccounts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public BillingAccount saveBillingAccount(@RequestBody BillingAccount account) {
        return billingAccountService.saveBillingAccount(account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBillingAccount(@PathVariable(name = "id") Long id) {
        billingAccountService.deleteBillingAccount(id);
        return ResponseEntity.noContent().build();
    }

    /*@RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<BillingAccount> getAccountByLoginAndPassword(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {
        System.out.println("login=" + login +"     /     "  + "password=" + password);
        Optional<BillingAccount> account = billingAccountService.getBillingAccountByLoginAndPassword(login, password);
        return account.isPresent() ? ResponseEntity.ok(account.get()) : ResponseEntity.ok(new BillingAccount());
    }
    */
}
