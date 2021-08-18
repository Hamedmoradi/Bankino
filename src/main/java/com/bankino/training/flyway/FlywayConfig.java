package com.bankino.training.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
class FlywayConfig {
@Bean
public Flyway flyway(DataSource dataSource) {
	Flyway flyway = new Flyway();
	flyway.setDataSource(dataSource);
	flyway.migrate();
	return flyway;
}
}