package com.example.stock.repository;

import com.example.stock.model.sectors;
import com.example.stock.model.stockexchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockExchangeRepository extends JpaRepository<stockexchange,Integer> {

    public stockexchange findByStockExchangeName(String name);
}
