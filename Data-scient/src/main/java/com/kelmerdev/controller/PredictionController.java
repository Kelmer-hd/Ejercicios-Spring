package com.kelmerdev.controller;

import com.kelmerdev.dto.PredictionRequest;
import com.kelmerdev.dto.PredictionResult;
import com.kelmerdev.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping
    public PredictionResult predictSales(@RequestBody PredictionRequest request) {
        return predictionService.predictSales(request);
    }
}