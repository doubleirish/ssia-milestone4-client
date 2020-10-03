package com.manning.ssia.milestone4_client.domain;

import lombok.Data;

import java.util.List;

@Data
public class HealthProfile {
  private String username;
  private List<HealthMetric> metrics;
}
