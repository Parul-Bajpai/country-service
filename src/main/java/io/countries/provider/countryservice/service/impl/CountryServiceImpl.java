package io.countries.provider.countryservice.service.impl;

import io.countries.provider.countryservice.model.CountryResponse;
import io.countries.provider.countryservice.request.CountryRequest;
import io.countries.provider.countryservice.service.CountryService;
import io.countries.provider.countryservice.webclient.RestCountryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CountryServiceImpl implements CountryService {

    @Autowired
    private RestCountryClient restCountryClient;
    @Override
    public CountryResponse getCountryData(CountryRequest countryRequest) {
        if(countryRequest!=null && countryRequest.getCountryName().isEmpty())
        {
            //get all countries
        }
        else {
            String countryName= countryRequest.getCountryName();
            // get country by name
        }
        return null;
    }
}
