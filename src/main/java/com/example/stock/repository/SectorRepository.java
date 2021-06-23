package com.example.stock.repository;

import com.example.stock.model.sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectorRepository extends JpaRepository<sectors,Integer> {
    public sectors findByName(String sectorName);
}
