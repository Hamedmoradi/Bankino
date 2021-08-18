package com.bankino.training.repository;

import com.bankino.training.domain.GeographicalAreaCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeographicalAreaCounterRepository extends JpaRepository<GeographicalAreaCounter, Long> {


}
