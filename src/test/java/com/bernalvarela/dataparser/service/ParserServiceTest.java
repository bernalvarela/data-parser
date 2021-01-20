package com.bernalvarela.dataparser.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.bernalvarela.dataparser.entity.ConnectionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ParserServiceTest {

  @ParameterizedTest
  @MethodSource("com.bernalvarela.dataparser.service.ParserServiceTestFixtures#parseLineException")
  void parseLine(String line, Class exception) {
    ParserService parserService = new ParserService();
    assertThatThrownBy(() -> {parserService.parseLine(line);}).isInstanceOf(exception);
  }

  @ParameterizedTest
  @MethodSource("com.bernalvarela.dataparser.service.ParserServiceTestFixtures#parseLine")
  void parseLine(String line, ConnectionInfo expectedValue) {
    ParserService parserService = new ParserService();
    assertThat(parserService.parseLine(line)).usingRecursiveComparison().isEqualTo(expectedValue);
  }

}
