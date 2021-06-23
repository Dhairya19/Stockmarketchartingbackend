package com.example.stock.service;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.SectorDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface SectorService {
    public SectorDto save(SectorDto sectorDto);
    public void deleteById(int id);
    public List<SectorDto> findAll();
    public SectorDto findById(int id);
    public List<CompanyDto> getCompanies(int id);
    public List<CompanyDto> getSectorCompanies(String sectorName);
    public SectorDto addCompanyToSector(String sectorName, CompanyDto companyDto);
}


