package com.manning.ssia.milestone4_client.controller;

import com.manning.ssia.milestone4_client.domain.HealthAdvice;
import com.manning.ssia.milestone4_client.domain.HealthProfile;
import com.manning.ssia.milestone4_client.service.AdviceService;
import com.manning.ssia.milestone4_client.service.HealthServerRemote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class GenAdviceController {

    @Resource
    AdviceService adviceService;

    @Resource
    HealthServerRemote healthServerRemote;

    @PostMapping("/genadvice")
    public void genAdvice(@RequestBody List<HealthProfile> healthProfiles) {
        log.info("received healthProfile {} ", healthProfiles);
        healthProfiles.forEach(hp -> {
            final HealthAdvice advice = adviceService.generate(hp);
            healthServerRemote.sendAdvice(advice);
        });

    }
}
