package com.example.ksqldbeventsourcing.domain.writemodel.command;

import com.example.ksqldbeventsourcing.eventsourcing.Command;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AcceptOrderCommand extends Command {

  UUID driverId;

  @Builder
  @JsonCreator
  public AcceptOrderCommand(UUID aggregateId, int originalVersion, UUID driverId) {
    super(aggregateId, originalVersion);
    this.driverId = driverId;
  }
}