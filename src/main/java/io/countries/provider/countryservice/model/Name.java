package io.countries.provider.countryservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {

    private String common;
    private String official;

    public String getCommon() {
        return common;
    }

    @SuppressWarnings(value = "unused")
    public void setCommon(String common) {
        this.common = common;
    }

    @SuppressWarnings(value = "unused")
    public String getOfficial() {
        return official;
    }

    @SuppressWarnings(value = "unused")
    public void setOfficial(String official) {
        this.official = official;
    }
}
