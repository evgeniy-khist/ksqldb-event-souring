package com.example.eventsourcing.ksqldb.domain.writemodel.event;

import com.example.eventsourcing.ksqldb.eventsourcing.Event;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderCancelledEvent extends Event {

  public OrderCancelledEvent(UUID aggregateId, int version) {
    super(aggregateId, version);
  }
}
