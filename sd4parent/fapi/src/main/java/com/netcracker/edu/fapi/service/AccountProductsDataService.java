package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.AccountProductsViewModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountProductsDataService {
    List<AccountProductsViewModel> getAll();
    AccountProductsViewModel getAccountProductsById(Long id);
    AccountProductsViewModel saveAccountProducts(AccountProductsViewModel accountProducts);
    void deleteAccountProducts(Long id);
}
