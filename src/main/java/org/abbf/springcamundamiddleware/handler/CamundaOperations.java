package org.abbf.springcamundamiddleware.handler;

import org.springframework.http.ResponseEntity;

public interface CamundaOperations {

    ResponseEntity<String> startCamundaProcess(String processId);
}
