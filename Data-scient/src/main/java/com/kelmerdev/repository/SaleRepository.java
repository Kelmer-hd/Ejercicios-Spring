package com.kelmerdev.repository;

import com.kelmerdev.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale s WHERE s.date BETWEEN ?1 AND ?2")
    List<Sale> findSalesBetweenDates(LocalDate startDate, LocalDate endDate);

    List<Sale> findByProductAndRegion(String product, String region);
}