package org.abbf.springcamundamiddleware.handler;


import org.abbf.springcamundamiddleware.tasks.CamundaTasks;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CamundaHttpOperations implements CamundaOperations {

    private final RestTemplate camundaTemplate;

    private final CamundaTasks camundaTasks;

    @Value("${camunda.endpoint}")
    private String camundaUrl;

    @Autowired
    public CamundaHttpOperations(@Qualifier("camundaRestTemplate") RestTemplate camundaTemplate,
                                 CamundaTasks camundaTasks) {
        this.camundaTemplate = camundaTemplate;
        this.camundaTasks = camundaTasks;
    }

    @Override
    public ResponseEntity<String> startCamundaProcess(String processId) {
//        "http://localhost:8080/engine-rest/process-definition/abbf_bpmn_process:1:47df5e4e-149b-11ec-b805-3699b57bf7f8/start"
        HttpEntity<JSONObject> httpEntity = this.buildStartRequest();
        String url = camundaUrl + "/process-definition/" + processId + "/start";
        this.camundaTasks.handleCamundaTasks();
        return this.camundaTemplate.postForEntity(url,
                httpEntity, String.class);

    }

    private HttpEntity<JSONObject> buildStartRequest() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(new JSONObject(), httpHeaders);
    }
}
