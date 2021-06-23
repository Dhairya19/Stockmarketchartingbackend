package com.example.stock.mapper;

import com.example.stock.Dto.StockPriceDto;
import com.example.stock.model.stockprice;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StockPriceMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public StockPriceDto toStockPriceDto(stockprice stockPrice)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StockPriceDto stockPriceDto=modelMapper.map(stockPrice,StockPriceDto.class);
        return stockPriceDto;
    }

    public stockprice toStockPrice(StockPriceDto stockPriceDto)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        stockprice stockPrice=modelMapper.map(stockPriceDto,stockprice.class);
        return stockPrice;
    }

    public List<StockPriceDto> toStockPriceDtos(List<stockprice> stockPrices)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<StockPriceDto> stockPriceDtos= Arrays.asList(modelMapper.map(stockPrices,StockPriceDto[].class));
        return stockPriceDtos;
    }

    public List<stockprice> toStockPrices(List<StockPriceDto> stockPriceDtos)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<stockprice> stockPrices = Arrays.asList(mapper.map(stockPriceDtos, stockprice[].class));
        return stockPrices;
    }
}