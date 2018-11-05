package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Feature;
import com.netcracker.edu.backend.repository.FeatureRepository;
import com.netcracker.edu.backend.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeatureServiceImpl implements FeatureService {

    private FeatureRepository repository;

    @Autowired
    public FeatureServiceImpl(FeatureRepository repository) {
        this.repository = repository;
    }

    @Override
    public Feature saveFeature(Feature feature) {
        return repository.save(feature);
    }

    @Override
    public Optional<Feature> getFeatureById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Feature> getAllFeatures() {
        return repository.findAll();
    }

    @Override
    public void deleteFeature(Long id) {
        repository.deleteById(id);
    }
}
