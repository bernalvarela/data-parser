package com.bernalvarela.dataparser.console.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ParamsParserServiceTest {

  @ParameterizedTest
  @MethodSource("com.bernalvarela.dataparser.console.service.ParamsParserServiceTestFixtures#parseParamsException")
  void parseLine(String[] params, String message, Class exception) {
    ParamsParserService paramsParserService = new ParamsParserService();
    assertThatThrownBy(() -> {paramsParserService.parseParams(params);}).hasMessageContaining(message).isInstanceOf(exception);
  }

  @ParameterizedTest
  @MethodSource("com.bernalvarela.dataparser.console.service.ParamsParserServiceTestFixtures#parseParams")
  void parseLine(String[] params, ExecutorParams expectedValue) {
    ParamsParserService paramsParserService = new ParamsParserService();
    assertThat(paramsParserService.parseParams(params)).usingRecursiveComparison().isEqualTo(expectedValue);
  }

}
