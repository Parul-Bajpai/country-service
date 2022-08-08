package io.countries.provider.countryservice.service;

import io.countries.provider.countryservice.response.CountriesResponse;
import io.countries.provider.countryservice.response.CountryResponse;
import io.countries.provider.countryservice.service.impl.CountryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CountryServiceImplTest {
    private final CountryServiceImpl countryService;

    public CountryServiceImplTest(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    @Test
    void getCountry() {
        String expectedName = "Finland";
        String expectedCountryCode = "FI";
        String expectedPopulation = "5530719";
        String expectedCapital = "Helsinki";
        CountryResponse countryResponse = countryService.getCountryData("Finland");
        assertNotNull(countryResponse);
        assertThat(countryResponse.getName()).isEqualTo(expectedName);
        assertThat(countryResponse.getCountry_code()).isEqualTo(expectedCountryCode);
        assertThat(countryResponse.getPopulation()).isEqualTo(expectedPopulation);
        assertThat(countryResponse.getCapital()).isEqualTo(expectedCapital);
    }

    @Test
    void getAllCountries() {
        int expectedSize = 200;

        CountriesResponse countriesResponse = countryService.getCountriesData();
        assertNotNull(countriesResponse);
        assertThat(countryService.getCountriesData().getCountries().size()).isGreaterThan(expectedSize);
    }
}
