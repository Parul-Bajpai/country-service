package io.countries.provider.countryservice.model;

import java.util.ArrayList;
import java.util.List;

public class CountryResponse {

    List<CountryData> countryData;

    public List<CountryData> getCountryData() {
        if(countryData!=null)
            return countryData;
        else
            return countryData=new ArrayList<>();
    }

}
