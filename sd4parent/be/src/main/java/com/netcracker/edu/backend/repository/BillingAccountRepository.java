package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.BillingAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillingAccountRepository extends CrudRepository<BillingAccount, Long> {
    /*List<BillingAccount> getBillingAccountsByRole(String userRoleName);
    Optional<BillingAccount> getBillingAccountByLoginAndPassword(String login, String password);*/
}
