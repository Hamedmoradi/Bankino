package com.bankino.training.service;

import com.bankino.training.domain.CounterReport;
import com.bankino.training.domain.ElectricityPrice;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface ElectricityPriceService {

    String calculatePeriodicCounterPrice(Date startDate, Date endDate, Long counterId);

}
