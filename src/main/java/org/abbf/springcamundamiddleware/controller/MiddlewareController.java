package org.abbf.springcamundamiddleware.controller;

import org.abbf.springcamundamiddleware.handler.CamundaOperations;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping(value = "/admin/start/{processId}")
    public @ResponseBody ResponseEntity<String> startProcess(@PathVariable("processId") String processId) {
        return this.camundaRestOperations.startCamundaProcess(processId);
    }



}
