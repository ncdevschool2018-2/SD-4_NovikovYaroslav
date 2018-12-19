package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.AccountProducts;
import com.netcracker.edu.backend.repository.AccountProductsRepository;
import com.netcracker.edu.backend.service.AccountProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import static com.netcracker.edu.backend.repository.specification.AccountProductsSpecification.subscriptionsFindByUserId;
@Component
public class AccountProductsServiceImpl implements AccountProductsService {

    private AccountProductsRepository repository;

    @Autowired
    public AccountProductsServiceImpl(AccountProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public AccountProducts saveAccountProducts(AccountProducts accountProducts) {
        return repository.save(accountProducts);
    }

    @Override
    public Optional<AccountProducts> getAccountProductsById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<AccountProducts> getAllAccountProducts() {
        return repository.findAll();
    }

    @Override
    public void deleteAccountProducts(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<AccountProducts> getAccountProductsByUserId(String login) {
        return this.repository.findAll(subscriptionsFindByUserId(login));
    }
}
