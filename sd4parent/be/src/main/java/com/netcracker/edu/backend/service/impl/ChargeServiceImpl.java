package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.AccountProducts;
import com.netcracker.edu.backend.repository.AccountProductsRepository;
import com.netcracker.edu.backend.repository.PurseRepository;
import com.netcracker.edu.backend.service.ChargeService;
import com.netcracker.edu.backend.service.AccountProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private PurseRepository walletRepository;

    @Autowired
    private AccountProductsRepository subscribeRepository;

    private List<AccountProducts> subscribe = new ArrayList<>();

    //@Scheduled (fixedRate = 5000)
    @Override
    public void scheduledCharge() {
        loadSubscription();
        decreaseAmount();
        System.out.println("сняло");
    }

    @Override
    public void loadSubscription() {
        Iterable<AccountProducts> iterableSubs = subscribeRepository.findAll();
        for (AccountProducts sub : iterableSubs) {
            subscribe.add(sub);
        }
    }

    @Override
    public boolean checkStatus(AccountProducts subscribe) {
        boolean status;
        Date localDate = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("YYYY-MM-DD");
        if(!localDate.before(subscribe.getDateEnd()) ||
                subscribe.getAccount().getPurse().getBalance() <
                        subscribe.getProduct().getCost()) {
            status = false;
            subscribeRepository.falseStatus(subscribe.getId());
        }
        else {
            status = true;
            subscribeRepository.trueStatus(subscribe.getId());
        }
        return status;
    }

    @Override
    public void decreaseAmount() {
        for (AccountProducts s: subscribe) {
            if (checkStatus(s)){
                walletRepository.updateBalancePurse(s.getProduct().getCost(),
                        s.getAccount().getPurse().getId());
            }
        }
    }

}
