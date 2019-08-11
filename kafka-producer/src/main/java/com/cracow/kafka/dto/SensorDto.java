package com.cracow.kafka.dto;

import java.io.Serializable;
import java.util.List;

public class SensorDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private String tenant;
  private String project;
  private String channelId;
  private String type;
  private List<Double> values;
  private double measureTimestampMilliseconds;
  private double measureDurationMilliseconds;

  public SensorDto(String tenant, String project, String channelId, String type,
      List<Double> values, double measureTimestampMilliseconds,
      double measureDurationMilliseconds) {
    this.tenant = tenant;
    this.project = project;
    this.channelId = channelId;
    this.type = type;
    this.values = values;
    this.measureTimestampMilliseconds = measureTimestampMilliseconds;
    this.measureDurationMilliseconds = measureDurationMilliseconds;
  }

  @Override
  public String toString() {
    return "SensorDto{" +
        "tenant='" + tenant + '\'' +
        ", project='" + project + '\'' +
        ", channelId='" + channelId + '\'' +
        ", type='" + type + '\'' +
        ", values=" + values +
        ", measureTimestampMilliseconds=" + measureTimestampMilliseconds +
        ", measureDurationMilliseconds=" + measureDurationMilliseconds +
        '}';
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public String getChannelId() {
    return channelId;
  }

  public void setChannelId(String channelId) {
    this.channelId = channelId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<Double> getValues() {
    return values;
  }

  public void setValues(List<Double> values) {
    this.values = values;
  }

  public double getMeasureTimestampMilliseconds() {
    return measureTimestampMilliseconds;
  }

  public void setMeasureTimestampMilliseconds(double measureTimestampMilliseconds) {
    this.measureTimestampMilliseconds = measureTimestampMilliseconds;
  }

  public double getMeasureDurationMilliseconds() {
    return measureDurationMilliseconds;
  }

  public void setMeasureDurationMilliseconds(double measureDurationMilliseconds) {
    this.measureDurationMilliseconds = measureDurationMilliseconds;
  }
}
