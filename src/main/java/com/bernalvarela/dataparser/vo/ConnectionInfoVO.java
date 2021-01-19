package com.bernalvarela.dataparser.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ConnectionInfoVO {

  private final Long timestamp;

  private final String originHost;

  private final String destinationHost;

}
