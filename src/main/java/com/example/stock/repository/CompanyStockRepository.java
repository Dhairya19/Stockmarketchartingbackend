package com.example.stock.repository;

import com.example.stock.model.companystock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyStockRepository extends JpaRepository<companystock, Integer> {
    
	public companystock findByCompanyCode(String code);
}
