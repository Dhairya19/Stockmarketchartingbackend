package com.example.stock.repository;

import com.example.stock.model.ipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IpoRepository extends JpaRepository<ipo,Integer> {
    public Optional<ipo> findById(int id);
    public List<ipo> findByCompanyName(String name);
    public void deleteById(int id);
}