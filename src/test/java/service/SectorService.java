package service;

import com.example.stock.StockApplication;
import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.SectorDto;
import com.example.stock.mapper.CompanyMapper;
import com.example.stock.model.company;
import com.example.stock.model.sectors;
import com.example.stock.repository.SectorRepository;
import com.example.stock.service.SectorService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
class SectorServiceTest {

    @Autowired
    private SectorService sectorService;


    @Test
    @DirtiesContext
    void save() {
        SectorDto sectorDto = sectorService.save(new SectorDto(1145,"Manufacturing", "Companies that produce new products."));
        assertEquals("Manufacturing",sectorDto.getName());
    }

    @Test
    @DirtiesContext
    void deleteById() {
        sectorService.deleteById(10001);
        assertNull(sectorService.findById(10001));
    }

    @Test
    void findAll() {
        List<SectorDto> sectorDtos=sectorService.findAll();
        assertNotNull(sectorDtos);

    }

    @Test
    void findById() {
        SectorDto sectorDto=sectorService.findById(10002);
        assertEquals("Pharmaceutical",sectorDto.getName());
    }

    @Test
    @Transactional
    void getCompanies() {
        List<CompanyDto> companyDtos = sectorService.getCompanies(10002);
        assertNotNull(companyDtos);

    }

    @Test
    @Transactional
    void getSectorCompanies() {
        List<CompanyDto> companyDtos = sectorService.getSectorCompanies("Petrochemical");
        assertNotNull(companyDtos);
    }
}
