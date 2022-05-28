package com.udaan.demo.controller;

import com.udaan.demo.entiies.Deal;
import com.udaan.demo.entiies.Item;
import com.udaan.demo.requestDtos.DealRequest;
import com.udaan.demo.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DealController {

    @Autowired
    private DealService dealService;

    @PostMapping("/deal")
    public ResponseEntity<Deal> createDeal(@RequestBody DealRequest dealRequest) {
        Deal deal = dealService.createDeal(parseDealRequest(dealRequest));
        return ResponseEntity.ok(deal);
    }

    @GetMapping("/deal")
    public ResponseEntity<List<Deal>> getDeals() {
        List<Deal> deals = dealService.getDeals();
        return ResponseEntity.ok(deals);
    }

    @PostMapping("/deal/claim/{dealId}")
    public ResponseEntity claimDeal(@PathVariable Integer dealId) throws Exception {
        Boolean isClaimed = dealService.claimDeal(dealId);
        if(isClaimed) {
            return ResponseEntity.ok("");
        }
        else {
            throw new Exception("Deal Expired");
        }
    }

    private Deal parseDealRequest(DealRequest dealRequest) {
        Deal deal = new Deal();
        deal.setItem(parseItem(dealRequest.getItem()));
        deal.setStartTime(dealRequest.getStartTime());
        dealRequest.setEndTime(dealRequest.getEndTime());
        return deal;
    }

    private Item parseItem(com.udaan.demo.requestDtos.Item item) {
        Item result = new Item();
        result.setName(item.getName());
        result.setQty(item.getQty());
        result.setPrice(item.getPrice());
        return result;
    }
}
