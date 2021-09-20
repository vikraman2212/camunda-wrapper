package org.abbf.springcamundamiddleware.controller;

import org.abbf.springcamundamiddleware.handler.CamundaOperations;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiddlewareController {


    private final CamundaOperations camundaRestOperations;

    @Autowired
    public MiddlewareController(CamundaOperations camundaRestClient) {
        this.camundaRestOperations = camundaRestClient;
    }


    /*@PutMapping(value = "/start/{processId}")
    public ResponseEntity<String> startProcess(@PathVariable("processId") String processId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JSONObject> request =
                new HttpEntity<JSONObject>(new JSONObject(), httpHeaders);
        System.out.println(camundaUrl + "/process-definition/" + processId +"/start");
        *//*String stringResponseEntity = this.camundaRestClient.
                postForObject("http://localhost:8080/engine-rest/process-definition/abbf_bpmn_process:1:47df5e4e-149b-11ec-b805-3699b57bf7f8/start",
                        request, String.class);*//*
        String stringResponseEntity = this.camundaRestClient.
                postForObject(camundaUrl + "/process-definition/" + processId +"/start",
                        request, String.class);

        return ResponseEntity.ok(stringResponseEntity.toString());
    }*/


    @PutMapping(value = "/start/{processId}")
    public @ResponseBody ResponseEntity<String> startProcess(@PathVariable("processId") String processId) {
        ResponseEntity<String> jsonObjectResponseEntity = this.camundaRestOperations.startCamundaProcess(processId);
        return jsonObjectResponseEntity;
    }



}
