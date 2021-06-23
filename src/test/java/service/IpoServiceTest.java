package service;


import com.example.stock.StockApplication;
import com.example.stock.Dto.IPODto;
import com.example.stock.repository.IpoRepository;
import com.example.stock.service.IpoService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.aspectj.runtime.internal.Conversions.intValue;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockApplication.class)
class IpoServiceTest {

    @Autowired
    private IpoService IpoServices;


    @Test
    void findAll() {
        List<IPODto> ipoDtos = IpoServices.findAll();
        assertNotNull(ipoDtos);
    }

    @Test
    void findById() {
        IPODto ipoDto = IpoServices.findById(40001);
        assertEquals("Reliance Jio",ipoDto.getCompanyName());
    }

    @Test
    @DirtiesContext
    @Transactional
    void save() {
        IPODto ipoDto = IpoServices.save(new IPODto(40017, BigDecimal.valueOf(intValue(123.4)),1400,"12-09-20 10:03:45","asd","Reliance Jio","NSE"));
        assertEquals("Britannia",ipoDto.getCompanyName());

    }

    @Test
    @DirtiesContext
    void deleteById() {
        IpoServices.deleteById(40001);
        assertNull(IpoServices.findById(40001));
    }
}
