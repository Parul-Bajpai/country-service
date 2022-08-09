package io.countries.provider.countryservice.service;

import io.countries.provider.countryservice.model.CountryData;
import io.countries.provider.countryservice.model.Name;
import io.countries.provider.countryservice.response.CountryResponse;
import io.countries.provider.countryservice.response.Flags;
import io.countries.provider.countryservice.service.impl.CountryServiceImpl;
import io.countries.provider.countryservice.webclient.RestCountryClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class CountryServiceImplTest {

    private final static Logger logger = LoggerFactory.getLogger(CountryServiceImplTest.class);
    @Mock
    RestCountryClient restCountryClient;
    @InjectMocks
    private CountryServiceImpl countryService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getCountryDataTest() throws Exception {
        CountryResponse countryResponse;
        List<CountryData> countriesConvertResponse = new ArrayList<>();
        CountryData countryData = new CountryData();
        Name name = new Name();
        name.setCommon("FINLAND");
        Flags f = new Flags();
        f.setPng("PNG");
        countryData.setName(name);
        countryData.setPopulation("123");
        countryData.setCountryCode("FI");
        countryData.setFlags(f);
        countriesConvertResponse.add(countryData);
        Mockito.when(restCountryClient.getCountriesResponse(ArgumentMatchers.anyString())).thenReturn(countriesConvertResponse);
        countryResponse = countryService.getCountryData("FINLAND");
        Assertions.assertNotNull(countryResponse);
    }

    @Test
    public void getAllCountries() throws Exception {
        CountryResponse countryResponse;
        List<CountryData> countriesConvertResponse = new ArrayList<>();
        CountryData countryData = new CountryData();
        Name name = new Name();
        name.setCommon("FINLAND");
        countryData.setName(name);
        countryData.setCountryCode("FI");
        countriesConvertResponse.add(countryData);

        CountryData countryData1 = new CountryData();
        Name name1 = new Name();
        name1.setCommon("FINLAND");
        countryData.setName(name1);
        countryData.setCountryCode("FI");
        countriesConvertResponse.add(countryData1);

        Mockito.when(restCountryClient.getCountriesResponse(ArgumentMatchers.anyString())).thenReturn(countriesConvertResponse);
        countryResponse = countryService.getCountryData("");
        logger.info("List of all the countries: " + countryResponse);
        Assertions.assertNotNull(countryResponse);
    }
}
