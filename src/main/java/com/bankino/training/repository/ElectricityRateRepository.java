package com.bankino.training.repository;

import com.bankino.training.domain.ElectricityRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityRateRepository extends JpaRepository<ElectricityRate, Long> {
    ElectricityRate findByGeographicalAreaCounterId(Long id);
}
