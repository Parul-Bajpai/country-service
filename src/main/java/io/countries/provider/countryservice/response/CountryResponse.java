package io.countries.provider.countryservice.response;

public class CountryResponse {

    private String name;

    private String country_code;

    private String population;

    private String capital;

    private Flags flag_file_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings(value = "unused")
    public String getCountry_code() {
        return country_code;
    }

    @SuppressWarnings(value = "unused")
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    @SuppressWarnings(value = "unused")
    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @SuppressWarnings(value = "unused")
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @SuppressWarnings(value = "unused")
    public Flags getFlag_file_url() {
        return flag_file_url;
    }

    public void setFlag_file_url(Flags flag_file_url) {
        this.flag_file_url = flag_file_url;
    }
}
