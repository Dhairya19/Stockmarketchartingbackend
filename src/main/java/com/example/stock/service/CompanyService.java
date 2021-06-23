package com.example.stock.service;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.IPODto;
import com.example.stock.Dto.StockPriceDto;

import java.util.List;

public interface CompanyService {
    public List<CompanyDto> getCompanies();
    public CompanyDto findById(int id);
    public List<CompanyDto> getMatchingCompanies(String pattern);
    public CompanyDto addCompany(CompanyDto companyDto);
    public CompanyDto editCompany(CompanyDto companyDto);
    public void deleteCompany(int id);
    public CompanyDto addIpoToCompany(String companyName, IPODto ipoDto);
    public List<IPODto> getCompanyIpoDetails(int id);
    public CompanyDto addStockPriceToCompany(String companyCode, StockPriceDto stockPriceDto);
    public List<StockPriceDto> getStockPrices(String companyName);
}
