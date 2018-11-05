package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Transaction;
import com.netcracker.edu.backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Transaction> getTransactionById(@PathVariable(name = "id") Long id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTransaction(@PathVariable(name = "id") Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

}
