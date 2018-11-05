package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.PurseViewModel;
import com.netcracker.edu.fapi.service.PurseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pu")
public class PurseDataController {

    @Autowired
    private PurseDataService purseDataService;

    @RequestMapping
    public ResponseEntity<List<PurseViewModel>> getAllPurses() {
        return ResponseEntity.ok(purseDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PurseViewModel> savePurse(@RequestBody PurseViewModel purse /*todo server validation*/) {
        if (purse != null) {
            return ResponseEntity.ok(purseDataService.savePurse(purse));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePurse(@PathVariable String id) {
        purseDataService.deletePurse(Long.valueOf(id));
    }

}
