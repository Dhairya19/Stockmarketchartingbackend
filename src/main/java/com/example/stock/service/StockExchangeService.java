package com.example.stock.service;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.StockExchangeDto;
import com.example.stock.model.company;

import java.util.List;
import java.util.Optional;

public interface StockExchangeService {
    public List<StockExchangeDto> findAll();
    public StockExchangeDto findById(int id);
    public StockExchangeDto save(StockExchangeDto stockExchangeDto);
    public StockExchangeDto update(StockExchangeDto stockExchangeDto);
    public void delete(int id);
    public List<CompanyDto> getCompanies(int id);
    public StockExchangeDto addCompanyToStockExchange(String stockExchangeName,String companyCode, company company);
}
