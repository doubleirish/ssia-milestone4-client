package com.manning.ssia.milestone4_client.service;

import com.manning.ssia.milestone4_client.domain.HealthAdvice;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class HealthServerRemote {

    @Value("${app.resourceUrlViaGateway}")
    private String resourceUrlViaGateway;

    public void sendAdvice(HealthAdvice advice) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<List<HealthAdvice>> adviceList = new HttpEntity<>(List.of(advice));
        log.info("connecting to  resourceUrlViaGateway {} ", resourceUrlViaGateway);
        log.info("sending advice {} ", adviceList);
        val responseEntity =
                restTemplate.postForEntity(resourceUrlViaGateway, adviceList, String.class);
        log.info("post to resource server /Advice returned status: {}" , responseEntity.getStatusCode());

    }
}
