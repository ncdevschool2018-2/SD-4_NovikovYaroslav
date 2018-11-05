package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.FeatureViewModel;
import com.netcracker.edu.fapi.service.FeatureDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fea")
public class FeatureDataController {

    @Autowired
    private FeatureDataService featureDataService;

    @RequestMapping
    public ResponseEntity<List<FeatureViewModel>> getAllFeatures() {
        return ResponseEntity.ok(featureDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FeatureViewModel> saveFeature(@RequestBody FeatureViewModel feature /*todo server validation*/) {
        if (feature != null) {
            return ResponseEntity.ok(featureDataService.saveFeature(feature));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFeature(@PathVariable String id) {
        featureDataService.deleteFeature(Long.valueOf(id));
    }

}
