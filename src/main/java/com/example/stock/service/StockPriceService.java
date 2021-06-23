package com.example.stock.service;

import com.example.stock.Dto.CompanyCompareRequest;
import com.example.stock.Dto.SectorCompareRequest;
import com.example.stock.Dto.StockPriceDto;

import java.text.ParseException;
import java.util.List;

public interface StockPriceService {
    public List<StockPriceDto> findAll();
    public StockPriceDto findById(int id);
    public void deleteById(int id);
    public List<StockPriceDto> save(List<StockPriceDto> stockPriceDtos);
    public StockPriceDto update(StockPriceDto stockPriceDto);
    public List<StockPriceDto> getStockPricesForCompanyComparison(CompanyCompareRequest compareRequest)throws ParseException;
    public List<StockPriceDto> getStockPricesForSectorComparison(SectorCompareRequest compareRequest)throws ParseException;
}