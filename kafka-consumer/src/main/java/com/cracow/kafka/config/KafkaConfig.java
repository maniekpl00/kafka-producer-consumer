package com.cracow.kafka.config;

public final class KafkaConfig {

  public static final String KAFKA_BROKERS = "localhost:9092";

  public static final Integer MESSAGE_COUNT = 2;

  public static final String CLIENT_ID = "kafka-producer";

  public static final String TOPIC_NAME = "topic_demo";

  public static final String GROUP_ID_CONFIG = "consumerGroup";

  public static final Integer MAX_NO_MESSAGE_FOUND_COUNT = 200;

  public static final String OFFSET_RESET_LATEST = "latest";

  public static final String OFFSET_RESET_EARLIER = "earliest";

  public static final Integer MAX_POLL_RECORDS = 1;
}
