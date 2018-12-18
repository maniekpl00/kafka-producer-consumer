package com.cracow.kafka.deserializer;

import com.cracow.kafka.dto.SensorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;

public class DeviceDeserializer implements Deserializer<SensorDto> {
  private ObjectMapper mapper;

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
    if(mapper == null) {
      mapper = new ObjectMapper();
    }
  }

  @Override
  public SensorDto deserialize(String topic, byte[] data) {
    SensorDto result;
    try {
      result = mapper.readValue(data, SensorDto.class);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
    return result;
  }

  @Override
  public void close() {
    mapper = null;
  }
}
