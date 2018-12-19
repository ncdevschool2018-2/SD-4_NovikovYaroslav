package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Purse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PurseRepository extends JpaRepository<Purse, Long>, JpaSpecificationExecutor<Purse> {
    @Modifying
    @Transactional
    @Query("update Purse p set p.balance = p.balance - :money where p.id = :purseId")
    void updateBalancePurse(@Param("money") Integer money,
                             @Param("purseId")Long purseId);

    @Modifying
    @Transactional
    @Query("update Purse p set p.balance = p.balance + :amount where p.id = :id")
    void topUpBalancePurse(@Param("amount") Integer amount, @Param("id") Long id);

    @Query("select p from Purse p where p.idAcc = :userId")
    Optional<Purse> getPurseByOwnerId(@Param("userId")Long userId);

}