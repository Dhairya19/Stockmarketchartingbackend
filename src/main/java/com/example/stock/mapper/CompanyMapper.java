package com.example.stock.mapper;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.model.company;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CompanyMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public CompanyDto toCompanyDto(company company)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyDto companyDto=modelMapper.map(company,CompanyDto.class);
        return companyDto;
    }

    public company toCompany(CompanyDto companyDto)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        company company=modelMapper.map(companyDto,company.class);
        return company;
    }

    public List<CompanyDto> toCompanyDtos(List<company> company)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CompanyDto> companyDtos= Arrays.asList(modelMapper.map(company,CompanyDto[].class));
        return companyDtos;
    }
}
