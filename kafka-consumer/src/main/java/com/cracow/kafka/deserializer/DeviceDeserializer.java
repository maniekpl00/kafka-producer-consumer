package com.cracow.kafka.deserializer;

import com.cracow.kafka.dto.DeviceDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;

public class DeviceDeserializer implements Deserializer<DeviceDto> {
  private static final ObjectMapper mapper = new ObjectMapper();

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {

  }

  @Override
  public DeviceDto deserialize(String topic, byte[] data) {
    DeviceDto result = null;
    try {
      result = mapper.readValue(data, DeviceDto.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public void close() {

  }
}
