package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.AccountProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountProductsRepository extends CrudRepository<AccountProducts, Long> {
}
