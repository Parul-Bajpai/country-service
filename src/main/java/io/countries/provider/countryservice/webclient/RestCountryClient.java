package io.countries.provider.countryservice.webclient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class RestCountryClient {

//    String url="http://";



//     third party call for all and name
//     2 methods will be there

//    public getCountryDetails(String countryName)
//    {
//        if(countryName.isEmpty())
//        {
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//            String res = response.body().string();
//            logger.info("Response :{}", res);
//            convertResponse = mapper.readValue(res, ExchangeConvertResponse.class);
//        }
//    }
}
