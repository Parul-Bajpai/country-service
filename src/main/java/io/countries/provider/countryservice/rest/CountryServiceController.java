package io.countries.provider.countryservice.rest;

import io.countries.provider.countryservice.response.CountriesResponse;
import io.countries.provider.countryservice.response.CountryResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import io.countries.provider.countryservice.service.CountryService;


@Component
@EnableAutoConfiguration
@RestController
@RequestMapping(value="/api", produces="application/json", consumes="application/json")
public class CountryServiceController {
    private final static Logger logger = LoggerFactory.getLogger(CountryServiceController.class);

    private final CountryService countryService;

    public CountryServiceController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries/")
    public ResponseEntity<CountriesResponse> getAllCountriesData() {
        CountriesResponse countryResponse = null;
        try {
                logger.info(" getAllCountriesData ");
                countryResponse = countryService.getCountriesData();
                logger.info("Response received Applicable Size");
                return new ResponseEntity<>(countryResponse, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(countryResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/countries/{name}")
    public ResponseEntity<CountryResponse> getCountryData(@PathVariable String name ) {
        CountryResponse countryResponse = null;
        try {
            if(StringUtils.isEmpty(name))
            {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            logger.info("Input: Country Name: {}", name);
            countryResponse = countryService.getCountryData(name);
            return new ResponseEntity<>(countryResponse, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(countryResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
