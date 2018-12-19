package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.MoneyOperation;
import com.netcracker.edu.backend.entity.Purse;

import java.util.Optional;

public interface PurseService {
    Purse savePurse(Purse purse);
    Optional<Purse> getPurseById(Long id);
    Iterable<Purse> getAllPurses();
    void deletePurse(Long id);
    Optional<Purse> getPurseByOwnerId(Long id);
    void fillUp(MoneyOperation purse);
}
