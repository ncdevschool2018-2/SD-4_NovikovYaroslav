package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.FeatureViewModel;
import com.netcracker.edu.fapi.service.FeatureDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FeatureDataServiceImpl implements FeatureDataService{

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<FeatureViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        FeatureViewModel[] featureViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/features/", FeatureViewModel[].class);
        return featureViewModelResponse == null ? Collections.emptyList() : Arrays.asList(featureViewModelResponse);
    }

    @Override
    public FeatureViewModel getFeatureById(Long id) {
        return null;
    }

    @Override
    public FeatureViewModel saveFeature(FeatureViewModel feature) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/features", feature, FeatureViewModel.class).getBody();
    }

    @Override
    public void deleteFeature(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/features/" + id);
    }
}
