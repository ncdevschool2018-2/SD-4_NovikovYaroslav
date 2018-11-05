package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.AccountProducts;

import java.util.Optional;

public interface AccountProductsService {
    AccountProducts saveAccountProducts(AccountProducts accountProducts);
    Optional<AccountProducts> getAccountProductsById(Long id);
    Iterable<AccountProducts> getAllAccountProducts();
    void deleteAccountProducts(Long id);
}
