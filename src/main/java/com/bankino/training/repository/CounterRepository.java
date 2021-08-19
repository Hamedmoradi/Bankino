package com.bankino.training.repository;

import com.bankino.training.domain.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {

Counter findCounterByCounterNo(String counterNo);

}
