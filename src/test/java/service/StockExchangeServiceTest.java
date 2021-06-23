package service;

import com.example.stock.StockApplication;
import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.StockExchangeDto;
import com.example.stock.repository.StockExchangeRepository;
import com.example.stock.service.StockExchangeService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockApplication.class)
class StockExchangeServiceTest {


    @Autowired
    private StockExchangeService stockExchangeService;

    @Test
    void findAll() {
        List<StockExchangeDto> stockExchangeDtoList = stockExchangeService.findAll();
        assertNotNull(stockExchangeDtoList);
    }

    @Test
    void findById() {
        StockExchangeDto stockExchangeDto = stockExchangeService.findById(20002);
        assertEquals("BSE",stockExchangeDto.getStockExchangeName());
    }

    @Test
    @DirtiesContext
    @Transactional
    void save() {
        StockExchangeDto stockExchangeDto = stockExchangeService.save(new StockExchangeDto(1234,"QWE","ASDFG","QWERTY","QWERFGH"));
        assertEquals("QWE",stockExchangeDto.getStockExchangeName());
    }

    @Test
    @DirtiesContext
    @Transactional
    void update() {
        StockExchangeDto stockExchangeDto = stockExchangeService.update(new StockExchangeDto(20001,"QWE","ASDFG","QWERTY","QWERFGH"));
        assertEquals("QWE",stockExchangeDto.getStockExchangeName());
    }

    @Test
    @Transactional
    void getCompanies() {
        List<CompanyDto> companyDtos = stockExchangeService.getCompanies(20002);
        assertNotNull(companyDtos);
    }
    @Test
    @DirtiesContext
    @Transactional
    void delete() {
        stockExchangeService.delete(20001);
        assertNull(stockExchangeService.findById(20001));
    }
}
