package com.manning.ssia.milestone4_client.domain;

import lombok.Data;

@Data
public class HealthAdvice {

    public HealthAdvice() {
    }

    public HealthAdvice(final String username, final String advice) {
        this.advice = advice;
        this.username = username;
    }

    private  String advice;
    private  String username;

}
