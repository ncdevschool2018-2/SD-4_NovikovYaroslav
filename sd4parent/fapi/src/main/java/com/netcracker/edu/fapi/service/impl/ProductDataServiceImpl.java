package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.service.ProductDataService;
import com.netcracker.edu.fapi.models.ProductViewModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductDataServiceImpl implements ProductDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<ProductViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/products/", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public ProductViewModel getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModels = restTemplate.getForObject(backendServerUrl + "api/products/", ProductViewModel[].class);

        if (productViewModels != null) {
            for (ProductViewModel entityViewModel : productViewModels) {
                if (entityViewModel.getId() == id)
                    return entityViewModel;
            }
        }
        return null;
    }

    @Override
    public ProductViewModel saveProduct(ProductViewModel product) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/products", product, ProductViewModel.class).getBody();
    }

    @Override
    public void deleteProduct(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/products/" + id);
    }
    /*@Override
    public List<ProductViewModel> getProductsByPage(int page) {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "api/products/page/" + page, ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public int getTotalPages() {
        RestTemplate restTemplate = new RestTemplate();
        int response = restTemplate.getForObject(backendServerUrl + "api/products/total-pages", Integer.class);
        return response;
    }*/
}
