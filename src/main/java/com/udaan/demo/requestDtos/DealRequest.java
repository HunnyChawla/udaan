package com.udaan.demo.requestDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DealRequest {
    private Item item;
    private Long startTime;
    private Long endTime;
}
