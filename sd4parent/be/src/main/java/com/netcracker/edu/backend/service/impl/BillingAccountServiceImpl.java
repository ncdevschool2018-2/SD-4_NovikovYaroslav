package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.repository.BillingAccountRepository;
import com.netcracker.edu.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Component
public class BillingAccountServiceImpl implements BillingAccountService {

    private BillingAccountRepository repository;

    @Autowired
    public BillingAccountServiceImpl(BillingAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public BillingAccount saveBillingAccount(BillingAccount account) {
        return repository.save(account);
    }

    @Override
    public Optional<BillingAccount> getBillingAccountById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<BillingAccount> getAllBillingAccounts() {
        return repository.findAll();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        repository.deleteById(id);
    }

    /*@Override
    public List<BillingAccount> getBillingAccountsByRole(String userRoleName) {
        return repository.getBillingAccountsByRole(userRoleName);
    }

    @Override
    public Optional<BillingAccount> getBillingAccountByLoginAndPassword(@NotNull String login, @NotNull String password) {
        return repository.getBillingAccountByLoginAndPassword(login, password);
    }*/
}
