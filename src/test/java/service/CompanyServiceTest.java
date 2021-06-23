package service;

import com.example.stock.StockApplication;
import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.IPODto;
import com.example.stock.Dto.StockPriceDto;
import com.example.stock.repository.CompanyRepository;
import com.example.stock.service.CompanyService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.aspectj.runtime.internal.Conversions.intValue;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockApplication.class)
class CompanyServiceTest {

    @Autowired
    private CompanyService companyServices;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void getCompanies() {
        List<CompanyDto> companyDtos= companyServices.getCompanies();
        assertNotNull(companyDtos);
    }

    @Test
    void findById() {
        CompanyDto companyDto = companyServices.findById(30001);
        assertEquals("Reliance Jio",companyDto.getCompanyName());
    }
    
   

    @Test
    void getMatchingCompanies() {
        List<CompanyDto> companyDtos =companyServices.getMatchingCompanies("Reliance");
        assertEquals("Relaince Jio",(companyDtos.get(0)).getCompanyName());
    }

    @Test
    @DirtiesContext
    @Transactional
    void addCompany() {
        CompanyDto companyDto = new CompanyDto(30008,"Reliance Jio","zxc","qwertyui","ASD", BigDecimal.valueOf(intValue(12345)),"AQW32","BSE","Telecom");
        CompanyDto companyDto1 = companyServices.addCompany(companyDto);
        assertEquals("Reliance Jio",companyDto1.getCompanyName());
    }

    @Test
    @Transactional
    void getCompanyIpoDetails() {
        List<IPODto> ipoDtos = companyServices.getCompanyIpoDetails(30001);
        assertNotNull(ipoDtos);
    }

    @Test
    @Transactional
    void getStockPrices() {
        List<StockPriceDto> stockPriceDtos = companyServices.getStockPrices("Reliance Jio");
        assertNotNull(stockPriceDtos);
    }
    @Test
    @DirtiesContext
    @Transactional
    void deleteCompany() {
        companyServices.deleteCompany(30001);
        assertNull(companyServices.findById(30001));
    }
}