package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Feature;

import java.util.Optional;

public interface FeatureService {
    Feature saveFeature(Feature product);
    Optional<Feature> getFeatureById(Long id);
    Iterable<Feature> getAllFeatures();
    void deleteFeature(Long id);
}
