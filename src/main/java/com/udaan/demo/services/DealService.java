package com.udaan.demo.services;

import com.udaan.demo.entiies.Deal;

import java.util.List;

public interface DealService {
    Deal createDeal(Deal deal);
    List<Deal> getDeals();
    boolean endDeal(Integer dealId);
    Deal updateDeal(Deal deal);
    boolean claimDeal(Integer deal_id);
}
