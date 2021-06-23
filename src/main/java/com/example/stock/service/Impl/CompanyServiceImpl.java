package com.example.stock.service.Impl;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.IPODto;
import com.example.stock.Dto.StockPriceDto;
import com.example.stock.mapper.CompanyMapper;
import com.example.stock.mapper.IPOMapper;
import com.example.stock.mapper.StockPriceMapper;
import com.example.stock.model.*;
import com.example.stock.repository.CompanyRepository;
import com.example.stock.repository.CompanyStockRepository;
import com.example.stock.repository.SectorRepository;
import com.example.stock.service.CompanyService;
import com.example.stock.service.SectorService;
import com.example.stock.service.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService
{
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyStockRepository companyStockRepository;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private IPOMapper ipoMapper;

    @Autowired
    private StockPriceMapper stockPriceMapper;

    @Autowired
    private SectorService sectorService;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private StockExchangeService stockExchangeService;

    @Override
    public List<CompanyDto> getCompanies()
    {
        List<company> companies = companyRepository.findAll();
        return companyMapper.toCompanyDtos(companies);
    }

    @Override
    public CompanyDto findById(int id)
    {
        Optional<company> company = companyRepository.findById(id);
        if(!company.isPresent())
            return null;
        return companyMapper.toCompanyDto(company.get());
    }

    @Override
    public List<CompanyDto> getMatchingCompanies(String pattern)
    {
        List<company> companies = companyRepository.findByCompanyNameIgnoreCaseContaining(pattern);
        return companyMapper.toCompanyDtos(companies);
    }

    @Override
    public CompanyDto addCompany(CompanyDto companyDto)
    {
        company company = companyMapper.toCompany(companyDto);
        sectors sector = sectorRepository.findByName(companyDto.getSectorName());
        company.setSectors(sector);
        company = companyRepository.save(company);
        companyDto = companyMapper.toCompanyDto(company);
        sectorService.addCompanyToSector(company.getSectorName(), companyDto);
        String[] stockExchangeNames = company.getStockExchangeName().split(",");
        String[] companyCodes = companyDto.getCompanyCode().split(",");
        for(int i=0; i<companyCodes.length;i++) {
            stockExchangeService.addCompanyToStockExchange(stockExchangeNames[i],companyCodes[i], company);
        }
        return companyDto;
    }

    @Override
    public CompanyDto editCompany(CompanyDto companyDto)
    {
        if(findById(companyDto.getId()) == null)
            return null;
        company updatedCompany = companyRepository.save(companyMapper.toCompany(companyDto));
        return companyMapper.toCompanyDto(updatedCompany);
    }

    @Override
    public void deleteCompany(int id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<IPODto> getCompanyIpoDetails(int id)
    {
        Optional<company> company = companyRepository.findById(id);
        if(!company.isPresent())
            return null;
        List<ipo> ipos = company.get().getIpos();
        return ipoMapper.toIPODtos(ipos);
    }

    @Override
    public List<StockPriceDto> getStockPrices(String companyName)
    {
        company company = companyRepository.findByCompanyName(companyName);
        if(company == null)
            return null;
        return stockPriceMapper.toStockPriceDtos(company.getStockprices());
    }

    @Override
    public CompanyDto addIpoToCompany(String companyName, IPODto ipoDto)
    {
        company company = companyRepository.findByCompanyName(companyName);
        if(company == null)
            return null;
        ipo ipo = ipoMapper.toIPO(ipoDto);
        company.getIpos().add(ipo);
        company = companyRepository.save(company);
        return companyMapper.toCompanyDto(company);
    }

    @Override
    public CompanyDto addStockPriceToCompany(String companyCode, StockPriceDto stockPriceDto)
    {
        companystock companystock = companyStockRepository.findByCompanyCode(companyCode);
        company company=companystock.getCompany();
        if(company == null)
            return null;
        company.getStockprices().add(stockPriceMapper.toStockPrice(stockPriceDto));
        company = companyRepository.save(company);
        return companyMapper.toCompanyDto(company);
    }
}
