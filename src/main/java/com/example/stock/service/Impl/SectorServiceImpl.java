package com.example.stock.service.Impl;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.SectorDto;
import com.example.stock.mapper.CompanyMapper;
import com.example.stock.mapper.SectorMapper;
import com.example.stock.model.sectors;
import com.example.stock.repository.SectorRepository;
import com.example.stock.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectorServiceImpl implements SectorService
{
    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private SectorMapper sectorMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public SectorDto save(SectorDto sectorDto) {
        sectors sector = sectorMapper.toSector(sectorDto);
        sector = sectorRepository.save(sector);
        return sectorMapper.toSectorDto(sector);
    }

    @Override
    public List<SectorDto> findAll() {
        Iterable<sectors> sa = sectorRepository.findAll();

        List<sectors> sectors = new ArrayList<>();

        // Add each element of iterator to the List
        for (sectors s : sa) {
            sectors.add(s);
        }

        return sectorMapper.toSectorDtos(sectors);
    }

    @Override
    public SectorDto findById(int id) {
        Optional<sectors> sector = sectorRepository.findById(id);
        if(!sector.isPresent())
            return null;
        return sectorMapper.toSectorDto(sector.get());
    }

    @Override
    public void deleteById(int id) {
        sectorRepository.deleteById(id);
    }

    @Override
    public List<CompanyDto> getCompanies(int id)
    {
        Optional<sectors> sector = sectorRepository.findById(id);
        if(!sector.isPresent())
            return null;
        return companyMapper.toCompanyDtos(sector.get().getCompanies());
    }
    @Override
    public List<CompanyDto> getSectorCompanies(String sectorName)
    {
        sectors sector = sectorRepository.findByName(sectorName);
        if(sector == null)
            return null;
        return companyMapper.toCompanyDtos(sector.getCompanies());
    }

    @Override
    public SectorDto addCompanyToSector(String sectorName, CompanyDto companyDto)
    {
        sectors sector = sectorRepository.findByName(sectorName);
        if(sector == null)
            return null;
        sector.getCompanies().add(companyMapper.toCompany(companyDto));
        sector = sectorRepository.save(sector);
        return sectorMapper.toSectorDto(sector);
    }



}
