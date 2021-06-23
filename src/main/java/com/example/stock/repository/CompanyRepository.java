package com.example.stock.repository;

import com.example.stock.model.company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<company, Integer> {
    public Optional<company> findById(int id);
    public List<company> findByCompanyNameIgnoreCaseContaining(String pattern);
    public company findByCompanyName(String name);
}
