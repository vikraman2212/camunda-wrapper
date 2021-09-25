package org.abbf.springcamundamiddleware.tasks;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaTasks {
    protected static final Logger LOG = LoggerFactory.getLogger(CamundaTasks.class);

    @Bean
    @ExternalTaskSubscription("externalTopic")
    public ExternalTaskHandler handleCamundaTasks() {
        return ((externalTask, externalTaskService) -> {
            LOG.info("initialized logger {}",externalTask.getActivityId());
            System.out.println(externalTask.getActivityId());
            externalTaskService.complete(externalTask);
        });
    }

  /*  @Bean
    public ClientRequestInterceptor interceptor() {
        return context -> {
            LOG.info("Request interceptor called!");
            context.addHeader("X-MY-HEADER", "External Tasks Rock!");
        };
    }*/
}
