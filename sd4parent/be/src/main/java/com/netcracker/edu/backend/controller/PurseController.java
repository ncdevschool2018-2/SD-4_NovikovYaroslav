package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Purse;
import com.netcracker.edu.backend.service.PurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/purses")
public class PurseController {
    private PurseService purseService;

    @Autowired
    public PurseController(PurseService purseService) {
        this.purseService = purseService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Purse> getPurseById(@PathVariable(name = "id") Long id) {
        Optional<Purse> purse = purseService.getPurseById(id);
        if (purse.isPresent()) {
            return ResponseEntity.ok(purse.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Purse> getAllPurses() {
        return purseService.getAllPurses();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Purse savePurse(@RequestBody Purse purse) {
        return purseService.savePurse(purse);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePurse(@PathVariable(name = "id") Long id) {
        purseService.deletePurse(id);
        return ResponseEntity.noContent().build();
    }

}
