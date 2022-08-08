package io.countries.provider.countryservice.service;

import io.countries.provider.countryservice.response.CountriesResponse;
import io.countries.provider.countryservice.response.CountryResponse;

public interface CountryService {

    CountryResponse getCountryData(String name);

    CountriesResponse getCountriesData();

}
