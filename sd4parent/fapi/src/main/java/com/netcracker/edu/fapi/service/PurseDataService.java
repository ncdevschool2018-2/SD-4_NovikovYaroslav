package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.PurseViewModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PurseDataService {
    List<PurseViewModel> getAll();
    PurseViewModel getPurseById(Long id);
    PurseViewModel savePurse(PurseViewModel purse);
    void deletePurse(Long id);
}
