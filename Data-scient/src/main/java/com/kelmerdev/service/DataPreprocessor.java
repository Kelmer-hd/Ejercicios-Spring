package com.kelmerdev.service;

import com.kelmerdev.model.Sale;
import org.springframework.stereotype.Service;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

import java.util.List;

@Service
public class DataPreprocessor {

    public Table preprocessSalesData(List<Sale> sales) {
        Table table = Table.create("sales");

        // Convertir lista de ventas a formato tabular
        DateColumn dateColumn = DateColumn.create("date");
        DoubleColumn amountColumn = DoubleColumn.create("amount");

        for (Sale sale : sales) {
            dateColumn.append(sale.getDate());
            amountColumn.append(sale.getAmount());
        }

        table.addColumns(dateColumn, amountColumn);

        // Agregar características adicionales
        table.addColumns(
                dateColumn.dayOfWeek().setName("dayOfWeek"),
                dateColumn.monthValue().setName("month"),
                dateColumn.year().setName("year")
        );

        return table;
    }
}
