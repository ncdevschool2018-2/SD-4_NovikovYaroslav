package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.AccountProducts;

public interface ChargeService {
    void scheduledCharge();
    void loadSubscription();
    boolean checkStatus(AccountProducts subscribe);
    void decreaseAmount();
}