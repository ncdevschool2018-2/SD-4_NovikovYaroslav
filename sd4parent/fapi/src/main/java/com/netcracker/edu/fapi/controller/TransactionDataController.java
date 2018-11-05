package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.TransactionViewModel;
import com.netcracker.edu.fapi.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tr")
public class TransactionDataController {

    @Autowired
    private TransactionDataService transactionDataService;

    @RequestMapping
    public ResponseEntity<List<TransactionViewModel>> getAllTransactions() {
        return ResponseEntity.ok(transactionDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TransactionViewModel> saveTransaction(@RequestBody TransactionViewModel transaction /*todo server validation*/) {
        if (transaction != null) {
            return ResponseEntity.ok(transactionDataService.saveTransaction(transaction));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTransaction(@PathVariable String id) {
        transactionDataService.deleteTransaction(Long.valueOf(id));
    }

}
