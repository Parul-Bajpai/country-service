package io.countries.provider.countryservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.countries.provider.countryservice.response.Flags;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryData {
    private Name name;
    @JsonProperty("cca2")
    private String countryCode;

    @JsonProperty("population")
    private String population;
    @JsonProperty("flags")
    private Flags flags;

    @JsonProperty("capital")
    private String[] capital;



    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }
    @SuppressWarnings(value = "unused")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    @SuppressWarnings(value = "unused")
    public String getPopulation() {
        return population;
    }
    @SuppressWarnings(value = "unused")
    public void setPopulation(String population) {
        this.population = population;
    }

    public Flags getFlags() {
        return flags;
    }
    @SuppressWarnings(value = "unused")
    public void setFlags(Flags flags) {
        this.flags = flags;
    }
    @SuppressWarnings(value = "unused")
    public String[] getCapital() {
        return capital;
    }
    @SuppressWarnings(value = "unused")
    public void setCapital(String[] capital) {
        this.capital = capital;
    }

}
