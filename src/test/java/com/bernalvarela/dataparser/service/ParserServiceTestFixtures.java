package com.bernalvarela.dataparser.service;

import com.bernalvarela.dataparser.entity.ConnectionInfo;
import com.bernalvarela.dataparser.exception.InvalidLineFormat;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class ParserServiceTestFixtures {

  static Stream<Arguments> parseLineException() {
    return Stream.of(
        Arguments.of("a a a", NumberFormatException.class),
        Arguments.of("1 a a a", InvalidLineFormat.class)
    );
  }

  static Stream<Arguments> parseLine() {
    return Stream.of(
        Arguments.of("1 a a", ConnectionInfo.builder().timestamp(1L).originHost("a").destinationHost("a").build())
    );
  }

}