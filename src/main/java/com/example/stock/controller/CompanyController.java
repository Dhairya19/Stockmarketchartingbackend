package com.example.stock.controller;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.IPODto;
import com.example.stock.Dto.StockPriceDto;
import com.example.stock.exception.NotFoundException;
import com.example.stock.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/companies")
public class CompanyController
{
    @Autowired
    private CompanyService companyService;

    @GetMapping(path = "")
    public ResponseEntity<List<CompanyDto>> getCompanies()
    {
        return ResponseEntity
                .ok(companyService.getCompanies());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyDto> getCompanyDetails(@PathVariable int id)
            throws NotFoundException
    {
        CompanyDto companyDto = companyService.findById(id);
        if(companyDto == null) {
            throw new NotFoundException("Company not found at id : " + id);
        }
        return ResponseEntity.ok(companyDto);
    }

    @GetMapping(path = "/match/{pattern}")
    public ResponseEntity<List<CompanyDto>> getMatchingCompanies(@PathVariable String pattern)
    {
        return ResponseEntity.ok(companyService.getMatchingCompanies(pattern));
    }

    @GetMapping(path = "/{id}/ipos")
    public ResponseEntity<List<IPODto>> getCompanyIpoDetails(@PathVariable int id)
            throws NotFoundException
    {
        List<IPODto> ipoDtos = companyService.getCompanyIpoDetails(id);
        if(ipoDtos == null) {
            throw new NotFoundException("Company not found at id : " + id);
        }
        return ResponseEntity.ok(ipoDtos);
    }

    @GetMapping(path = "/{id}/stockPrices")
    public ResponseEntity<List<StockPriceDto>> getStockPrices(@PathVariable int id)
            throws NotFoundException
    {
        CompanyDto company = companyService.findById(id);
        List<StockPriceDto> stockPriceDtos = companyService.getStockPrices(company.getCompanyCode());
        if(stockPriceDtos == null) {
            throw new NotFoundException("Company not found at id : " + id);
        }
        return ResponseEntity.ok(stockPriceDtos);
    }

    @PostMapping(path = "")
    public ResponseEntity<?> addCompany(@RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(companyService.addCompany(companyDto));
    }

    @PutMapping(path = "")
    public ResponseEntity<CompanyDto> editCompany(@RequestBody CompanyDto companyDto)
            throws NotFoundException
    {
        CompanyDto updatedCompanyDto = companyService.editCompany(companyDto);
        if(updatedCompanyDto == null) {
            throw new NotFoundException("Company not found at id : " + companyDto.getId());
        }
        return ResponseEntity.ok(updatedCompanyDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
    }


    @PostMapping(path = "/{companyName}/ipos")
    public void addIpoToCompany(@PathVariable String companyName, @RequestBody IPODto ipoDto)
            throws NotFoundException
    {
        CompanyDto companyDto = companyService.addIpoToCompany(companyName, ipoDto);
        if(companyDto == null) {
            throw new NotFoundException("Company not with name : " + companyName);
        }
    }

    @PostMapping(path = "/{companyCode}/stockPrices")
    public void addStockPriceToCompany(@PathVariable String companyCode, @RequestBody StockPriceDto stockPriceDto)
            throws NotFoundException
    {
        CompanyDto companyDto = companyService.addStockPriceToCompany(companyCode, stockPriceDto);
        if(companyDto == null) {
            throw new NotFoundException("Company not with code : " + companyCode);
        }
    }

}
