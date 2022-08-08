package io.countries.provider.countryservice.service.impl;

import io.countries.provider.countryservice.model.CountryData;
import io.countries.provider.countryservice.response.CountriesResponse;
import io.countries.provider.countryservice.response.CountryResponse;
import io.countries.provider.countryservice.service.CountryService;
import io.countries.provider.countryservice.webclient.RestCountryClient;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryServiceImpl implements CountryService {
    private final static Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);
    @Autowired
    private RestCountryClient restCountryClient;

    @Override
    public CountryResponse getCountryData(String name) {
        CountryResponse countryResponse=new CountryResponse();
        List<CountryData> countriesConvertResponse;
        try {
            countriesConvertResponse = restCountryClient.getCountriesResponse(name);
            if(CollectionUtils.isNotEmpty(countriesConvertResponse)) {
                for (CountryData countryData : countriesConvertResponse) {
                    countryResponse.setName(countryData.getName().getCommon());
                    countryResponse.setCountry_code(countryData.getCountryCode());
                    countryResponse.setCapital(ArrayUtils.isNotEmpty(countryData.getCapital()) ? countryData.getCapital()[0] : "");
                    countryResponse.setPopulation(countryData.getPopulation());
                    countryResponse.setFlag_file_url(countryData.getFlags());
                }
            }
        }catch(Exception e)
        {
            logger.error("Exception occurred while calling country info", e);
        }

        return countryResponse;
    }

    @Override
    public CountriesResponse getCountriesData() {

        CountriesResponse countriesResponse=new CountriesResponse();
        List<CountryResponse> countryResponseList=new ArrayList<>();
        List<CountryData> countriesConvertResponse;
        try {
            countriesConvertResponse=restCountryClient.getCountriesResponse("");
            if(CollectionUtils.isNotEmpty(countriesConvertResponse))
            {
                for(CountryData countryData:countriesConvertResponse)
                {
                    CountryResponse countryResponse=new CountryResponse();
                    countryResponse.setName(countryData.getName().getCommon());
                    countryResponse.setCountry_code(countryData.getCountryCode());
                    countryResponseList.add(countryResponse);
                }
                countriesResponse.setCountries(countryResponseList);
            }

        }catch(Exception e)
        {
            logger.error("Exception occurred while calling country info :", e);
        }
        return countriesResponse;
    }
}
