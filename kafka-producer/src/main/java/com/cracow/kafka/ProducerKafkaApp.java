package com.cracow.kafka;

import com.cracow.kafka.config.KafkaConfig;
import com.cracow.kafka.dto.SensorDto;
import com.cracow.kafka.producer.ProducerKafkaCreator;
import com.cracow.kafka.serializer.DeviceSerializer;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerKafkaApp {

  public static void main(String[] args) {
    run();
  }

  private static void run() {
//    final Producer<Long, SensorDto> producer = ProducerKafkaCreator.build();
//    final DeviceSerializer deviceSerializer = new DeviceSerializer();

//    Runnable runnable = new Runnable() {
//      @Override
//      public void run() {
//        final Producer<Long, SensorDto> producer = ProducerKafkaCreator.build();
//        final DeviceSerializer deviceSerializer = new DeviceSerializer();
//        for(int i = 0; i < 1; i++) {
//          SensorDto sensorDto = new SensorDto("ca", "maniek", "channel1", "messages", new LinkedList<Double>() {{
//            add(1D);
//            add(721D);
//          }}, Instant.now().toEpochMilli(), 4000);
//
//          final ProducerRecord<Long, SensorDto> record =
//              new ProducerRecord<>(KafkaConfig.TOPIC_NAME, Long.valueOf(i), sensorDto);
//          try {
//            RecordMetadata metadata = producer.send(record).get();
//            producer.send(record).get();
//            String messageLog = String.format("Key: %s, partition: %s, offset: %s, value: %s",
//                i, metadata.partition(), metadata.offset(), sensorDto);
//            System.out.println(messageLog);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          } catch (ExecutionException e) {
//            e.printStackTrace();
//          }
//        }
//        producer.close();
//      }
//    };
//    int count = 1;
//    Thread [] threads = new Thread[count];
//    for(int i = 0; i < count; i++) {
//      threads[i] = new Thread(runnable);
//      threads[i].start();
//    }
//



    final Producer<Long, SensorDto> producer = ProducerKafkaCreator.build();
    final DeviceSerializer deviceSerializer = new DeviceSerializer();
    for(int i = 0; i < 1; i++) {
      SensorDto sensorDto = new SensorDto("ca", "maniek", "channel1", "messages", new LinkedList<Double>() {{
        add(3D);
        add(721D);
      }}, Instant.now().toEpochMilli(), 5000);

      final ProducerRecord<Long, SensorDto> record =
          new ProducerRecord<>(KafkaConfig.TOPIC_NAME, Long.valueOf(i), sensorDto);
      try {
        RecordMetadata metadata = producer.send(record).get();
        String messageLog = String.format("Key: %s, partition: %s, offset: %s, value: %s",
            i, metadata.partition(), metadata.offset(), sensorDto);
        System.out.println(messageLog);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    producer.close();
  }
}
