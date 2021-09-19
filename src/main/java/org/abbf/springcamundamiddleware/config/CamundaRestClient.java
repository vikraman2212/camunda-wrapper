package org.abbf.springcamundamiddleware.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CamundaRestClient {

    @Value("${camunda.endpoint}")
    private String camundaUrl;

    @Bean
    @Qualifier("camundaRestTemplate")
    public RestTemplate buildCamundaUri(RestTemplateBuilder restTemplateBuilder) {

        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        RestTemplate camundaTemplate = restTemplateBuilder.build();
        camundaTemplate.getMessageConverters().add(jsonHttpMessageConverter);
        return camundaTemplate;
    }




}
