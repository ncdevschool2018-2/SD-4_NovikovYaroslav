package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Transaction;
import com.netcracker.edu.backend.repository.TransactionRepository;
import com.netcracker.edu.backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository repository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
