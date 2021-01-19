package com.bernalvarela.dataparser.service;

import com.bernalvarela.dataparser.entity.ConnectionInfo;
import com.bernalvarela.dataparser.exception.InvalidLineFormat;

public class ParserService {

  public ConnectionInfo parseLine(String line) {
    String[] values = line.split(" ");
    validateValues(values);
    return ConnectionInfo.builder()
        .timestamp(Long.parseLong(values[0]))
        .originHost(values[1])
        .destinationHost(values[2])
        .build();
  }

  private void validateValues(String[] values) {
    if (values.length > 3) {
      throw new InvalidLineFormat();
    }
  }
}
