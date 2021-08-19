package com.bankino.training.service;

import java.util.Date;

public interface ElectricityPriceService {

    String calculatePeriodicCounterPrice(Date startDate, Date endDate, Long counterId);

}
