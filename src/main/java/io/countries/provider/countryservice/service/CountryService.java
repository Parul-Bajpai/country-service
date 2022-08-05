package io.countries.provider.countryservice.service;

import io.countries.provider.countryservice.model.CountryResponse;
import io.countries.provider.countryservice.request.CountryRequest;

public interface CountryService {

    public CountryResponse getCountryData(CountryRequest countryRequest);

}
