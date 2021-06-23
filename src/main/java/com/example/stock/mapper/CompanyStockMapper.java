package com.example.stock.mapper;

import com.example.stock.Dto.CompanyDto;
import com.example.stock.Dto.CompanyStockDto;
import com.example.stock.model.companystock;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CompanyStockMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public CompanyStockDto toCompanyStockDto(companystock companystock)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyStockDto companyStockDto=modelMapper.map(companystock,CompanyStockDto.class);
        return companyStockDto;
    }

    public companystock toCompanyStock(CompanyStockDto companyStockDto)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        companystock companystock=modelMapper.map(companyStockDto,companystock.class);
        return companystock;
    }

    public List<CompanyStockDto> toCompanyStockDtos(List<companystock> companystocks)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CompanyStockDto> companyStockDtos= Arrays.asList(modelMapper.map(companystocks,CompanyStockDto[].class));
        return companyStockDtos;
    }
}
