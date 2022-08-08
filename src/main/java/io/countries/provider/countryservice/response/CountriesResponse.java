package io.countries.provider.countryservice.response;

import java.util.ArrayList;
import java.util.List;

public class CountriesResponse {

    List<CountryResponse> countries;

    public List<CountryResponse> getCountries() {
        if (countries == null)
            return new ArrayList<>();
        return countries;
    }

    public void setCountries(List<CountryResponse> countries) {
        this.countries = countries;
    }
}


