package com.bankino.training.service;

import com.bankino.training.domain.Log;

import java.util.Optional;

public interface LogService {
Optional<Log> save(Log log);
}
