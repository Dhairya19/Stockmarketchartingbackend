package com.example.stock.service.Impl;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.CompanyStockDto;
import com.example.stock.Dto.StockExchangeDto;
import com.example.stock.mapper.CompanyMapper;
import com.example.stock.mapper.CompanyStockMapper;
import com.example.stock.mapper.StockExchangeMapper;
import com.example.stock.model.company;
import com.example.stock.model.companystock;
import com.example.stock.model.sectors;
import com.example.stock.model.stockexchange;
import com.example.stock.repository.CompanyRepository;
import com.example.stock.repository.CompanyStockRepository;
import com.example.stock.repository.StockExchangeRepository;
import com.example.stock.service.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {
    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Autowired
    private CompanyStockRepository companyStockRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StockExchangeMapper stockExchangeMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyStockMapper companyStockMapper;


    @Override
    public List<StockExchangeDto> findAll() {
        Iterable<stockexchange> st = stockExchangeRepository.findAll();

        List<stockexchange> stockExchanges = new ArrayList<>();

        // Add each element of iterator to the List
        for (stockexchange s : st) {
            stockExchanges.add(s);
        }
        return stockExchangeMapper.toStockExchangeDtos(stockExchanges);
    }

    @Override
    public StockExchangeDto findById(int id) {
        Optional<stockexchange> stockExchange = stockExchangeRepository.findById(id);
        if (!stockExchange.isPresent())
            return null;
        return stockExchangeMapper.toStockExchangeDto(stockExchange.get());
    }

    @Override
    public StockExchangeDto save(StockExchangeDto stockExchangeDto) {
        stockexchange stockExchange = stockExchangeMapper.toStockExchange(stockExchangeDto);
        stockExchange = stockExchangeRepository.save(stockExchange);
        return stockExchangeMapper.toStockExchangeDto(stockExchange);
    }

    @Override
    public StockExchangeDto update(StockExchangeDto stockExchangeDto) {
        if (findById(stockExchangeDto.getId()) == null)
            return null;
        stockexchange stockExchange = stockExchangeMapper.toStockExchange(stockExchangeDto);
        stockExchange = stockExchangeRepository.save(stockExchange);
        return stockExchangeMapper.toStockExchangeDto(stockExchange);
    }

    @Override
    public void delete(int id) {
        stockExchangeRepository.deleteById(id);
    }

    @Override
    public List<CompanyDto> getCompanies(int id)
    {
        Optional<stockexchange> stockExchange = stockExchangeRepository.findById(id);
        if(!stockExchange.isPresent())
            return null;
        Iterable<companystock> ct = stockExchange.get().getCompanystocks();
        List<company> company = new ArrayList<>();

        // Add each element of iterator to the List
        for (companystock s : ct) {
            company.add(s.getCompany());
        }
        return companyMapper.toCompanyDtos(company);
    }

    @Override
    public StockExchangeDto addCompanyToStockExchange(String stockExchangeName,String companyCode, company company)
    {
        stockexchange stockExchange = stockExchangeRepository.findByStockExchangeName(stockExchangeName);
        if(stockExchange == null)
            return null;
        companystock cs = new companystock( companyCode,company,stockExchange);
        /*cs.setCompanyCode(companyCode);
        cs.setStockexchange(stockExchange);
        cs.setCompany(company);*/
        companyStockRepository.save(cs);
        ((List<companystock>) stockExchange.getCompanystocks()).add(cs);
        company.getCompanystocks().add(cs);
        company company1 = companyRepository.save(company);
        stockExchange = stockExchangeRepository.save(stockExchange);
        return stockExchangeMapper.toStockExchangeDto(stockExchange);
    }


}

