package com.kelmerdev.dto;

import lombok.Data;

@Data
public class PredictionRequest {
    private String product;
    private String region;
    private Integer forecastDays;
}
