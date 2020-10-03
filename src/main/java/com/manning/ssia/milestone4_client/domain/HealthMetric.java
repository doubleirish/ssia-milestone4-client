package com.manning.ssia.milestone4_client.domain;

import lombok.Data;

@Data
public class HealthMetric {
  private HealthMetricType type;
  private double value;
}
