package io.countries.provider.countryservice.rest;

import io.countries.provider.countryservice.model.CountryResponse;
import io.countries.provider.countryservice.request.CountryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.countries.provider.countryservice.service.CountryService;


@Component
@EnableAutoConfiguration
@RestController
@RequestMapping(value="/api", produces="application/json", consumes="application/json")
public class CountryServiceController {
    private final static Logger logger = LoggerFactory.getLogger(CountryServiceController.class);

    @Autowired
    private CountryService countryService;

    @PostMapping("/getCountries")
    public ResponseEntity<CountryResponse> getAllCountriesData(@RequestBody CountryRequest countryRequest) {
        CountryResponse countryResponse;
        try {
                logger.info("Input: Country Name: {}", countryRequest);
                countryResponse = countryService.getCountryData(countryRequest);
                logger.info("Response received Applicable Size: {}");
                return new ResponseEntity<CountryResponse>(countryResponse, HttpStatus.OK);

        } catch (Exception e) {
            countryResponse =null;
            return new ResponseEntity<CountryResponse>(countryResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
