package com.example.stock.mapper;

import com.example.stock.Dto.SectorDto;
import com.example.stock.model.sectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SectorMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public SectorDto toSectorDto(sectors sector)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        SectorDto sectorDto=modelMapper.map(sector, SectorDto.class);
        return sectorDto;
    }

    public sectors toSector(SectorDto sectorDto)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        sectors sector=modelMapper.map(sectorDto,sectors.class);
        return sector;
    }

    public List<SectorDto> toSectorDtos(List<sectors> sector)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<SectorDto> sectorDtos= Arrays.asList(modelMapper.map(sector,SectorDto[].class));
        return sectorDtos;
    }
}
