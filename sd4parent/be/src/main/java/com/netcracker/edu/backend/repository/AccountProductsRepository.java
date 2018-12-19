package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.AccountProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountProductsRepository extends JpaRepository<AccountProducts, Long>, JpaSpecificationExecutor<AccountProducts> {

    @Modifying
    @Transactional
    @Query("update AccountProducts ap set ap.status = false where ap.id = :id")
    void falseStatus(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update AccountProducts ap set ap.status = true where ap.id = :id")
    void trueStatus(@Param("id") Long id);
}