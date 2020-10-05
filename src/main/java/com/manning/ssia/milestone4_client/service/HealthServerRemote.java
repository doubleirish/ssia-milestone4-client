package com.manning.ssia.milestone4_client.service;

import com.manning.ssia.milestone4_client.domain.HealthAdvice;
import com.manning.ssia.milestone4_client.security.ClientTokenService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class HealthServerRemote {

    @Value("${app.resourceUrlViaGateway}")
    private String resourceUrlViaGateway;

    @Resource
    private ClientTokenService clientTokenService;




    public void sendAdvice(HealthAdvice advice) {
        final OAuth2AccessToken accessToken = clientTokenService.getAccessToken();
        assert accessToken !=null;

        String token = accessToken.getTokenValue();
        final Set<String> scopes = accessToken.getScopes();
        assert scopes.contains("advice");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<List<HealthAdvice>> adviceList = new HttpEntity<>(List.of(advice),headers);

        log.info("posting advice {} to  resourceUrlViaGateway {} ", adviceList, resourceUrlViaGateway);
        RestTemplate restTemplate = new RestTemplate();
        val responseEntity =
                restTemplate.postForEntity(resourceUrlViaGateway, adviceList, Void.class);
        log.info("post to resource server /Advice returned status: {}" , responseEntity.getStatusCode());

    }
}
