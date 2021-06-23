package com.example.stock.controller;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.StockExchangeDto;
import com.example.stock.exception.NotFoundException;
import com.example.stock.model.company;
import com.example.stock.repository.StockExchangeRepository;
import com.example.stock.service.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/stockExchanges")
public class StockExchangeController {
    @Autowired
    private StockExchangeService stockExchangeService;

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @GetMapping(path = "")
    public ResponseEntity<List<StockExchangeDto>> findAll() {
        return ResponseEntity.ok(stockExchangeService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StockExchangeDto> findById(@PathVariable int id)
            throws NotFoundException
    {
        StockExchangeDto stockExchangeDto = stockExchangeService.findById(id);
        if(stockExchangeDto == null) {
            throw new NotFoundException("Stock Exchange Not Found for id : " + id);
        }
        return ResponseEntity.ok(stockExchangeDto);
    }

    @PostMapping(path = "")
    public ResponseEntity<StockExchangeDto> save(@RequestBody StockExchangeDto stockExchangeDto) {
        return ResponseEntity.ok(stockExchangeService.save(stockExchangeDto));
    }

    @PutMapping(path = "")
    public ResponseEntity<StockExchangeDto> update(@RequestBody StockExchangeDto stockExchangeDto)
            throws NotFoundException
    {
        StockExchangeDto updatedStockExchangeDto = stockExchangeService.update(stockExchangeDto);
        if(updatedStockExchangeDto == null) {
            throw new NotFoundException("Stock Exchange Not Found for id : " + stockExchangeDto.getId());
        }
        return ResponseEntity.ok(updatedStockExchangeDto);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable int id) {
        stockExchangeService.delete(id);
    }

    @GetMapping(path = "/{id}/companies")
    public ResponseEntity<List<CompanyDto>> getCompanies(@PathVariable int id)
            throws NotFoundException
    {
        List<CompanyDto> companyDtos = stockExchangeService.getCompanies(id);
        if(companyDtos == null) {
            throw new NotFoundException("Stock Exchange Not Found for id : " + id);
        }
        return ResponseEntity.ok(companyDtos);
    }


    @PostMapping(path = "/{stockExchangeName}/{companyCode}/companies")
    public void addCompanyToStockExchange(@PathVariable String stockExchangeName,@PathVariable String companyCode, @RequestBody company company)
            throws NotFoundException
    {
        StockExchangeDto stockExchangeDto = stockExchangeService.addCompanyToStockExchange(stockExchangeName,companyCode,company);
        if(stockExchangeDto == null) {
            throw new NotFoundException("Stock Exchange Not Found with name : " + stockExchangeName);
        }
    }
}

