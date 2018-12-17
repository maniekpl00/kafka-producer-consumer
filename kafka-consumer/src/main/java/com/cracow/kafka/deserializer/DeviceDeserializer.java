package com.cracow.kafka.deserializer;

import com.cracow.kafka.dto.SensorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;

public class DeviceDeserializer implements Deserializer<SensorDto> {
  private static final ObjectMapper mapper = new ObjectMapper();

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {

  }

  @Override
  public SensorDto deserialize(String topic, byte[] data) {
    SensorDto result = null;
    try {
      result = mapper.readValue(data, SensorDto.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public void close() {

  }
}
