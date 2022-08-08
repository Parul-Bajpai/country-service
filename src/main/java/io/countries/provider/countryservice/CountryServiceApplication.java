package io.countries.provider.countryservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CountryServiceApplication {
	private final static Logger logger = LoggerFactory.getLogger(CountryServiceApplication.class);
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		SpringApplication.run(CountryServiceApplication.class, args);
		logger.info(" Application Started in {}", System.currentTimeMillis() - startTime);
	}

}
