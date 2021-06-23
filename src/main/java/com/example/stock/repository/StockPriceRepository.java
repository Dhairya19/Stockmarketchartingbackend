package com.example.stock.repository;

import com.example.stock.model.stockprice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPriceRepository extends JpaRepository<stockprice,Integer> {
    public List<stockprice> findByCompanyCodeAndStockExchangeName(String companyCode, String stockExchangeName);
}
