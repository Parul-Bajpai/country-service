package io.countries.provider.countryservice.request;

import com.fasterxml.jackson.annotation.JsonValue;

public class CountryRequest {
    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
