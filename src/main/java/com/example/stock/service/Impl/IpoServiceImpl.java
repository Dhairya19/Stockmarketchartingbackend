package com.example.stock.service.Impl;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.IPODto;
import com.example.stock.mapper.IPOMapper;
import com.example.stock.model.company;
import com.example.stock.model.ipo;
import com.example.stock.repository.CompanyRepository;
import com.example.stock.repository.IpoRepository;
import com.example.stock.service.CompanyService;
import com.example.stock.service.IpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IpoServiceImpl implements IpoService
{
    @Autowired
    private IpoRepository ipoRepository;

    @Autowired
    private IPOMapper ipoMapper;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public List<IPODto> findAll() {
        List<ipo> ipos = ipoRepository.findAll();
        return ipoMapper.toIPODtos(ipos);
    }

    @Override
    public IPODto findById(int id) {
        Optional<ipo> ipo = ipoRepository.findById(id);
        if(!ipo.isPresent())
            return null;
        return ipoMapper.toIPODto(ipo.get());
    }

    @Override
    public IPODto save(IPODto ipoDto) {
        ipo ipo = ipoMapper.toIPO(ipoDto);
        String name = ipo.getCompanyName();
        company company = companyRepository.findByCompanyName(name);
        ipo.setCompany(company);
        ipo = ipoRepository.save(ipo);
        ipoDto = ipoMapper.toIPODto(ipo);
        CompanyDto companyDto = companyService.addIpoToCompany(name, ipoDto);
        if(companyDto == null)
            return null;
        return ipoDto;
    }

    @Override
    public void deleteById(int id) {
        ipoRepository.deleteById(id);
    }
}