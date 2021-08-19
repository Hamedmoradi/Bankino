package com.bankino.training.service;

import java.text.ParseException;

public interface CounterReportService {

     void registerCounterReport(String jsonMessage) throws ParseException;
}
