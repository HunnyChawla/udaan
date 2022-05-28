package com.udaan.demo.services;

import com.udaan.demo.entiies.Deal;
import com.udaan.demo.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealServiceImpl implements DealService{

    @Autowired
    private DealRepository dealRepository;

    @Override
    public Deal createDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    @Override
    public List<Deal> getDeals() {
        return dealRepository.findAll();
    }

    @Override
    public boolean endDeal(Integer dealId) {
        return false;
    }

    @Override
    public Deal updateDeal(Deal deal) {
        return null;
    }

    @Override
    public boolean claimDeal(Integer deal_id) {

        return false;
    }
}
