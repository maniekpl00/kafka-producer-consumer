package com.cracow.kafka.serializer;

import com.cracow.kafka.dto.SensorDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.apache.kafka.common.serialization.Serializer;

public class DeviceSerializer implements Serializer<SensorDto> {

  private ObjectMapper mapper;

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
    if(mapper == null) {
      mapper = new ObjectMapper();
    }
  }

  @Override
  public byte[] serialize(String topic, SensorDto data) {
    byte[] result;
    try {
      result = mapper.writeValueAsString(data).getBytes();
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException(e);
    }
    return result;
  }

  @Override
  public void close() {
    mapper = null;
  }
}
