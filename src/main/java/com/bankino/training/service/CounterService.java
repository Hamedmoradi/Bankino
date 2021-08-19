package com.bankino.training.service;

import com.bankino.training.domain.Counter;

import java.util.List;
import java.util.Optional;
public interface CounterService {

Optional<Counter> getById(Long id);

List<Counter> getAll();

Counter create(Counter counter);

void delete(Long counterId);

Optional<Counter> getCounterByCounterNo(Counter counter);
}
