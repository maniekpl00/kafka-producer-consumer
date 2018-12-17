package com.cracow.kafka;

import com.cracow.kafka.config.KafkaConfig;
import com.cracow.kafka.consumer.ConsumerCreator;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class ConsumerKafkaApp {

  public static void main(String[] args) {
    run();
  }

  private static void run() {
    final Consumer<Long, String> consumer = ConsumerCreator.build();

    int noMessageToFetch = 0;

    while(noMessageToFetch < KafkaConfig.MESSAGE_COUNT) {
      final ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
      if(consumerRecords.isEmpty()) {
        noMessageToFetch++;
        continue;
      }
      consumerRecords.forEach(record -> print(record));
    }
  }

  private static void print(ConsumerRecord record) {
    System.out.println(record.key());
    System.out.println(record.value());
    System.out.println(record.partition());
    System.out.println(record.offset());
  }
}
