package com.example.stock.service.Impl;

import com.example.stock.Dto.CompanyCompareRequest;
import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.SectorCompareRequest;
import com.example.stock.Dto.StockPriceDto;
import com.example.stock.mapper.CompanyMapper;
import com.example.stock.mapper.StockPriceMapper;
import com.example.stock.model.company;
import com.example.stock.model.companystock;
import com.example.stock.model.stockprice;
import com.example.stock.repository.CompanyRepository;
import com.example.stock.repository.CompanyStockRepository;
import com.example.stock.repository.StockPriceRepository;
import com.example.stock.service.SectorService;
import com.example.stock.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StockPriceServiceImpl implements StockPriceService {
    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Autowired
    private CompanyStockRepository companyStockRepository;

    @Autowired
    private StockPriceMapper stockPriceMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private SectorService sectorService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<StockPriceDto> findAll() {
        List<stockprice> stockPrices = stockPriceRepository.findAll();
        return stockPriceMapper.toStockPriceDtos(stockPrices);
    }

    public StockPriceDto findById(int id) {
        Optional<stockprice> stockPrice = stockPriceRepository.findById(id);
        if(!stockPrice.isPresent())
            return null;
        return stockPriceMapper.toStockPriceDto(stockPrice.get());
    }

    public List<StockPriceDto> save(List<StockPriceDto> stockPriceDtos)
    {
        List<stockprice> stockPrices = stockPriceMapper.toStockPrices(stockPriceDtos);
        List<stockprice> sp1 = new ArrayList<stockprice>();
        for(stockprice sp:stockPrices){
            companystock companystock = companyStockRepository.findByCompanyCode(sp.getCompanyCode());
            sp.setCompany(companystock.getCompany());
            stockprice sp2 = stockPriceRepository.save(sp);
            sp1.add(sp2);
        }
        return stockPriceMapper.toStockPriceDtos(sp1);
    }

    public StockPriceDto update(StockPriceDto stockPriceDto)
    {
        if(findById(stockPriceDto.getId()) == null)
            return null;
        stockprice stockprice =stockPriceMapper.toStockPrice(stockPriceDto);
        companystock companystock = companyStockRepository.findByCompanyCode(stockprice.getCompanyCode());
        stockprice.setCompany(companystock.getCompany());
        stockprice stockPrice = stockPriceRepository.save(stockprice);
        return stockPriceMapper.toStockPriceDto(stockPrice);
    }

    public void deleteById(int id) {
        stockPriceRepository.deleteById(id);
    }

    @Override
    public List<StockPriceDto> getStockPricesForCompanyComparison(CompanyCompareRequest compareRequest)
            throws ParseException
    {
        Date fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getFromPeriod());
        Date toDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getToPeriod());
        logger.info("{compare request}->",compareRequest);
        logger.info("{CompanyCode,StockExchangeName}->",compareRequest.getCompanyCode(),compareRequest.getStockExchangeName());
        List<stockprice> stockPrices = stockPriceRepository
                .findByCompanyCodeAndStockExchangeName(compareRequest.getCompanyCode(), compareRequest.getStockExchangeName());
        logger.info("{StockPrice}->",stockPrices);
        List<stockprice> filteredList = stockPrices.stream()
                .filter(stockPrice -> {
                    Date date = null;
                    try {
                        date = new SimpleDateFormat("dd-MM-yyyy").parse(stockPrice.getDate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return date.after(fromDate) && date.before(toDate);
                })
                .collect(Collectors.toList());
        logger.info("{}",filteredList);
        return stockPriceMapper.toStockPriceDtos(filteredList);
    }

    @Override
    public List<StockPriceDto> getStockPricesForSectorComparison(SectorCompareRequest compareRequest)
            throws ParseException
    {
        Date fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getFromPeriod());
        Date toDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getToPeriod());
        List<stockprice> stockPricesForSector = new ArrayList<>();
        List<CompanyDto> companies = sectorService.getSectorCompanies(compareRequest.getSectorName());
        for(CompanyDto companyDto: companies )
        {
            company comp = companyMapper.toCompany(companyDto);
            logger.info("{Company}->",comp.getCompanyName());
            List<companystock> companystocks = comp.getCompanystocks();
            logger.info("{Company stocks}->",companystocks);
            for(companystock cs: companystocks)
            {
                List<stockprice> stockPrices = stockPriceRepository
                    .findByCompanyCodeAndStockExchangeName(cs.getCompanyCode(), compareRequest.getStockExchangeName());
                List<stockprice> filteredList = stockPrices.stream()
                        .filter(stockPrice -> {
                            Date date = null;
                            try {
                                date = new SimpleDateFormat("dd-MM-yyyy").parse(stockPrice.getDate());
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            return date.after(fromDate) && date.before(toDate);
                        })
                        .collect(Collectors.toList());
                stockPricesForSector.addAll(filteredList);
                logger.info("{}",filteredList);
            }
        }
        logger.info("{}",stockPricesForSector);
        return stockPriceMapper.toStockPriceDtos(stockPricesForSector);
    }
}
