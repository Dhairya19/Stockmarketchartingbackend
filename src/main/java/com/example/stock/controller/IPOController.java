package com.example.stock.controller;

import com.example.stock.Dto.IPODto;
import com.example.stock.exception.NotFoundException;
import com.example.stock.mapper.IPOMapper;
import com.example.stock.model.company;
import com.example.stock.model.ipo;
import com.example.stock.repository.CompanyRepository;
import com.example.stock.service.CompanyService;
import com.example.stock.service.IpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class IPOController
{
    @Autowired
    private IpoService ipoService;

    @RequestMapping(value = "/ipos",method=RequestMethod.GET)
    public ResponseEntity<List<IPODto>> findAll() {
        return ResponseEntity.ok(ipoService.findAll());
    }

    @RequestMapping(value = "/ipos/{id}",method=RequestMethod.GET)
    public ResponseEntity<IPODto> findById(@PathVariable int id)throws NotFoundException
    {
        IPODto ipoDto = ipoService.findById(id);
        if(ipoDto == null) {
            throw new NotFoundException("Ipo not found for id : " + id);
        }
        return ResponseEntity.ok(ipoDto);
    }

    @RequestMapping(value = "/ipos",method=RequestMethod.POST)
    public ResponseEntity<IPODto> save(@RequestBody IPODto ipoDto)throws NotFoundException
    {
        IPODto addedIPODto = ipoService.save(ipoDto);
        if(addedIPODto == null) {
            throw new NotFoundException("Company not found with name : " + ipoDto.getCompanyName());
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addedIPODto);
    }

    @RequestMapping(value = "/ipos",method=RequestMethod.PUT)
    public ResponseEntity<IPODto> update(@RequestBody IPODto ipoDto)
            throws NotFoundException
    {
        IPODto updatedIPODto = ipoService.save(ipoDto);
        if(updatedIPODto == null) {
            throw new NotFoundException("Ipo not found for id : " + ipoDto.getId());
        }
        return ResponseEntity.ok(updatedIPODto);
    }

    @RequestMapping(value = "/ipos/{id}",method=RequestMethod.DELETE)
    public void deleteById(@PathVariable int id) {
        ipoService.deleteById(id);
    }
}