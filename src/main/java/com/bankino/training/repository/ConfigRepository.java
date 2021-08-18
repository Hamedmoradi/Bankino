package com.bankino.training.repository;

import com.bankino.training.domain.Config;
import com.bankino.training.domain.CounterReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {

    Config findConfigByConfigKey(String configKey);
}
