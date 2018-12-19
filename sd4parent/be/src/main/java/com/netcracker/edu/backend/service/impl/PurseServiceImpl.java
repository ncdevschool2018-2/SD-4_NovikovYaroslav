package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.MoneyOperation;
import com.netcracker.edu.backend.entity.Purse;
import com.netcracker.edu.backend.repository.PurseRepository;
import com.netcracker.edu.backend.service.PurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PurseServiceImpl implements PurseService {

    private PurseRepository repository;

    @Autowired
    public PurseServiceImpl(PurseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Purse savePurse(Purse purse) {
        return repository.save(purse);
    }

    @Override
    public Optional<Purse> getPurseById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Purse> getAllPurses() {
        return repository.findAll();
    }

    @Override
    public void deletePurse(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Purse> getPurseByOwnerId (Long id) {
        return repository.getPurseByOwnerId(id);
    }

    @Override
    public void fillUp(MoneyOperation purse) {
        repository.topUpBalancePurse(purse.getAmount(), purse.getId());
    }
}
