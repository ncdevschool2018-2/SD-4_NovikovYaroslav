package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.MoneyOperationViewModel;
import com.netcracker.edu.fapi.models.PurseViewModel;
import com.netcracker.edu.fapi.service.PurseDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PurseDataServiceImpl implements PurseDataService{

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<PurseViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        PurseViewModel[] purseViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/purses", PurseViewModel[].class);
        return purseViewModelResponse == null ? Collections.emptyList() : Arrays.asList(purseViewModelResponse);
    }

    @Override
    public PurseViewModel getPurseById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/purses/" + id, PurseViewModel.class);
    }

    @Override
    public PurseViewModel savePurse(PurseViewModel purse) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/purses", purse, PurseViewModel.class).getBody();
    }

    @Override
    public void deletePurse(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/purses/" + id);
    }

    @Override
    public PurseViewModel getPurseByOwnerId(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/purses/?userId=" + id, PurseViewModel.class);
    }

    @Override
    public void topUpBalancePurse(MoneyOperationViewModel purse) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "/api/purses/fill", purse, MoneyOperationViewModel.class);
    }
}
