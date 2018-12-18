package com.cracow.kafka.dto;

import java.io.Serializable;

public class SensorDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private String id;
  private String serialNumber;
  private Long eventTime;

  public SensorDto() {
  }

  public SensorDto(String id, String serialNumber, Long eventTime) {
    this.id = id;
    this.serialNumber = serialNumber;
    this.eventTime = eventTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Long getEventTime() {
    return eventTime;
  }

  public void setEventTime(Long eventTime) {
    this.eventTime = eventTime;
  }

  @Override
  public String toString() {
    return "SensorDto{" +
        "id='" + id + '\'' +
        ", serialNumber='" + serialNumber + '\'' +
        '}';
  }
}
