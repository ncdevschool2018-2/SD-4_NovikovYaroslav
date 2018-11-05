package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.TransactionViewModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionDataService {
    List<TransactionViewModel> getAll();
    TransactionViewModel getTransactionById(Long id);
    TransactionViewModel saveTransaction(TransactionViewModel transaction);
    void deleteTransaction(Long id);
}
