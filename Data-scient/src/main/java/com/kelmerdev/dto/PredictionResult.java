package com.kelmerdev.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class PredictionResult {
    private String product;
    private String region;
    private Map<LocalDate, Double> predictions;
    private Double confidenceLevel;
}
