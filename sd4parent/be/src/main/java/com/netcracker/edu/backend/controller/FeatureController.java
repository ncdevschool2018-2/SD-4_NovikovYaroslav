package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Feature;
import com.netcracker.edu.backend.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    private FeatureService featureService;

    @Autowired
    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Feature> getProductById(@PathVariable(name = "id") Long id) {
        Optional<Feature> feature = featureService.getFeatureById(id);
        if (feature.isPresent()) {
            return ResponseEntity.ok(feature.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Feature> getAllFeatures() {
        return featureService.getAllFeatures();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Feature saveFeature(@RequestBody Feature feature) {
        return featureService.saveFeature(feature);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteFeature(@PathVariable(name = "id") Long id) {
        featureService.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }

}
