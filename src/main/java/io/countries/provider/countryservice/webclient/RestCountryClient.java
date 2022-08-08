package io.countries.provider.countryservice.webclient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.countries.provider.countryservice.model.CountryData;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class RestCountryClient {

    private final static Logger logger = LoggerFactory.getLogger(RestCountryClient.class);
    @Value("${countries.api.url}")
    private String countriesApiUrl;

    @Value("${countries.api.url.all}")
    private String countriesAllApiUrl;

    @Value("${countries.api.url.name}")
    private String countriesNameApiUrl;

    public List<CountryData> getCountriesResponse(String name) throws IOException {
        List<CountryData> convertResponse = null;
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        String finalUrl;
        if(StringUtils.isNotEmpty(name))
        {
            finalUrl=countriesApiUrl+countriesNameApiUrl+name;
        }
        else {
            finalUrl=countriesApiUrl+countriesAllApiUrl;
        }
        Request request = new Request.Builder()
                .url(finalUrl)
                .method("GET", null).build();
        Response response = client.newCall(request).execute();
        if (ObjectUtils.isNotEmpty(response) && ObjectUtils.isNotEmpty(response.body())) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String res = Objects.requireNonNull(response.body()).string();
            logger.info("Response :{}", res);
            TypeFactory typeFactory = mapper.getTypeFactory();
            convertResponse = mapper.readValue(res, typeFactory.constructCollectionType(List.class, CountryData.class));

        }
        return convertResponse;
    }
}
