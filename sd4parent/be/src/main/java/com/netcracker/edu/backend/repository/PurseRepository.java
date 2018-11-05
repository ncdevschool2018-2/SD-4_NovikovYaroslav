package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Purse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurseRepository extends CrudRepository<Purse, Long> {
}
