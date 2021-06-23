package com.example.stock.mapper;


import com.example.stock.Dto.StockExchangeDto;
import com.example.stock.model.stockexchange;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StockExchangeMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public StockExchangeDto toStockExchangeDto(stockexchange stockExchange)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StockExchangeDto stockExchangeDto=modelMapper.map(stockExchange,StockExchangeDto.class);
        return stockExchangeDto;
    }

    public stockexchange toStockExchange(StockExchangeDto stockExchangeDto)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        stockexchange stockExchange=modelMapper.map(stockExchangeDto,stockexchange.class);
        return stockExchange;
    }

    public List<StockExchangeDto> toStockExchangeDtos(List<stockexchange> stockExchange)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<StockExchangeDto> stockExchangeDtos= Arrays.asList(modelMapper.map(stockExchange,StockExchangeDto[].class));
        return stockExchangeDtos;
    }
}
