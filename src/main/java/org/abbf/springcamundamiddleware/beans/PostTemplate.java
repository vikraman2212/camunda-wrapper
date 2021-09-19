package org.abbf.springcamundamiddleware.beans;

import lombok.Data;

@Data
public class PostTemplate {
    private String id;

    private String definitionId;

    private String businessKey;

    private String caseInstanceId;

    private String tenantId;

    private String ended;

    private String suspended;

    private String links;

    private String variables;

}
