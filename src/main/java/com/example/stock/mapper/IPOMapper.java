package com.example.stock.mapper;

import com.example.stock.Dto.IPODto;
import com.example.stock.model.ipo;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class IPOMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public IPODto toIPODto(ipo Ipo)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        IPODto IpoDto=modelMapper.map(Ipo,IPODto.class);
        return IpoDto;
    }

    public ipo toIPO(IPODto IpoDto)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ipo Ipo=modelMapper.map(IpoDto,ipo.class);
        return Ipo;
    }

    public List<IPODto> toIPODtos(List<ipo> Ipo)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<IPODto> IpoDtos= Arrays.asList(modelMapper.map(Ipo,IPODto[].class));
        return IpoDtos;
    }
}