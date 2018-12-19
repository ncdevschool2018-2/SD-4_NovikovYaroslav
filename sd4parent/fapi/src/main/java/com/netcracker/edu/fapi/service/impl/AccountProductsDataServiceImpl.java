package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.AccountProductsViewModel;
import com.netcracker.edu.fapi.models.MoneyOperationViewModel;
import com.netcracker.edu.fapi.service.AccountProductsDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AccountProductsDataServiceImpl implements AccountProductsDataService{

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<AccountProductsViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        AccountProductsViewModel[] accountProductsViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/account-products/", AccountProductsViewModel[].class);
        return accountProductsViewModelResponse == null ? Collections.emptyList() : Arrays.asList(accountProductsViewModelResponse);
    }

    @Override
    public AccountProductsViewModel getAccountProductsById(Long id) {
        return null;
    }

    @Override
    public AccountProductsViewModel saveAccountProducts(AccountProductsViewModel accountProducts) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/account-products", accountProducts, AccountProductsViewModel.class).getBody();
    }

    @Override
    public void deleteAccountProducts(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/account-products/" + id);
    }

    @Override
    public List<AccountProductsViewModel> getAccountProductsByUserId(String login) {
        RestTemplate restTemplate = new RestTemplate();
        AccountProductsViewModel[] accountProductsViewModelResponse = restTemplate.getForObject(backendServerUrl + "api/account-products/?login=" + login, AccountProductsViewModel[].class);
        return accountProductsViewModelResponse == null ? Collections.emptyList() : Arrays.asList(accountProductsViewModelResponse);
    }

}
