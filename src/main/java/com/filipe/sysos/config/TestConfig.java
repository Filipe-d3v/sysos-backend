package com.filipe.sysos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.filipe.sysos.servicies.DBService;

@Configuration
@Profile("dev")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

	@Bean
	public void instaciaDB() {
		this.dbService.instanciaDB();
	}
}
