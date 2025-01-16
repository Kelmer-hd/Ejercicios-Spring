package com.kelmerdev.service;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.stereotype.Service;
import tech.tablesaw.api.Table;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeSeriesAnalyzer {

    public double[] calculateTrend(Table data) {
        SimpleRegression regression = new SimpleRegression();

        for (int i = 0; i < data.rowCount(); i++) {
            regression.addData(i, data.doubleColumn("amount").get(i));
        }

        return new double[] {
                regression.getIntercept(),
                regression.getSlope()
        };
    }

    public List<Double> calculateSeasonality(Table data, int period) {
        List<Double> seasonalFactors = new ArrayList<>();

        return seasonalFactors;
    }
}