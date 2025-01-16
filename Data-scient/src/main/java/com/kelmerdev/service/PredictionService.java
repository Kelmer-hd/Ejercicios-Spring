package com.kelmerdev.service;

import com.kelmerdev.dto.PredictionRequest;
import com.kelmerdev.dto.PredictionResult;
import com.kelmerdev.model.Sale;
import com.kelmerdev.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.tablesaw.api.Table;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PredictionService {

    private SaleRepository saleRepository;
    private DataPreprocessor preprocessor;
    private TimeSeriesAnalyzer analyzer;

    public PredictionResult predictSales(PredictionRequest request) {
        // Obtener datos históricos
        List<Sale> historicalSales = saleRepository
                .findByProductAndRegion(request.getProduct(), request.getRegion());

        // Preprocesar datos
        Table processedData = preprocessor.preprocessSalesData(historicalSales);

        // Calcular tendencia
        double[] trend = analyzer.calculateTrend(processedData);

        // Calcular predicciones
        Map<LocalDate, Double> predictions = new HashMap<>();
        LocalDate currentDate = LocalDate.now();

        for (int i = 1; i <= request.getForecastDays(); i++) {
            LocalDate forecastDate = currentDate.plusDays(i);
            double prediction = trend[0] + trend[1] * (processedData.rowCount() + i);
            predictions.put(forecastDate, prediction);
        }
        // Crear resultado
        PredictionResult result = new PredictionResult();
        result.setProduct(request.getProduct());
        result.setRegion(request.getRegion());
        result.setPredictions(predictions);
        result.setConfidenceLevel(0.95); // Ejemplo simplificado

        return result;
    }
}