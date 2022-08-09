package io.countries.provider.countryservice.rest;

import io.countries.provider.countryservice.response.CountriesResponse;
import io.countries.provider.countryservice.response.CountryResponse;
import io.countries.provider.countryservice.service.impl.CountryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CountryServiceController.class)
public class CountryServiceControllerTest {
    @MockBean
    CountryServiceImpl mockCountryServiceImpl;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_getAllCountriesDataTest() throws Exception {
        List<CountryResponse> countries = new ArrayList<>();
        CountriesResponse countriesResponse = new CountriesResponse();
        countriesResponse.setCountries(countries);
        CountryResponse c1 = new CountryResponse();
        c1.setName("FINLAND");
        c1.setCountry_code("FI");

        CountryResponse c2 = new CountryResponse();
        c2.setName("DUBAI");
        c2.setCountry_code("AE");

        countries.add(c1);
        countries.add(c2);

        Mockito.when(mockCountryServiceImpl.getCountriesData()).thenReturn(countriesResponse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/countries").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertNotNull(result);
    }

    @Test
    public void test_getCountryDataTest() throws Exception {
        List<CountryResponse> countries = new ArrayList<>();
        CountriesResponse countriesResponse = new CountriesResponse();
        countriesResponse.setCountries(countries);
        CountryResponse c1 = new CountryResponse();
        c1.setName("FINLAND");
        c1.setCountry_code("FI");
        c1.setCapital("HELSINKI");

        countries.add(c1);

        Mockito.when(mockCountryServiceImpl.getCountriesData()).thenReturn(countriesResponse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/countries/Finland").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertNotNull(result);
    }
}
