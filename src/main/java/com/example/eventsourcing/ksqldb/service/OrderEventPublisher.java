package com.example.eventsourcing.ksqldb.service;

import com.example.eventsourcing.ksqldb.config.KafkaTopicsConfig;
import com.example.eventsourcing.ksqldb.eventsourcing.Event;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventPublisher {

  private final EventJsonSerde jsonSerde;
  private final KafkaTemplate<String, String> kafkaTemplate;

  public void publish(Event event) {
    Objects.requireNonNull(event);
    log.debug("Publishing event {}", event);
    kafkaTemplate.send(
        KafkaTopicsConfig.TOPIC_ORDER_COMMANDS_AND_EVENTS,
        event.getAggregateId().toString(),
        jsonSerde.serialize(event));
  }
}
