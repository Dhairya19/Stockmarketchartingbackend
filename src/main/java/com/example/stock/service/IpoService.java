package com.example.stock.service;

import com.example.stock.Dto.IPODto;

import java.util.List;

public interface IpoService {
    public List<IPODto> findAll();
    public IPODto findById(int id);
    public IPODto save(IPODto ipoDto);
    public void deleteById(int id);
}
