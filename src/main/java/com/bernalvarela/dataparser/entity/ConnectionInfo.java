package com.bernalvarela.dataparser.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ConnectionInfo {

  private final Long timestamp;

  private final String originHost;

  private final String destinationHost;

}
