package com.bernalvarela.dataparser.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.bernalvarela.dataparser.executor.MainExecutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserServiceTest {

  @ParameterizedTest
  @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
  @MethodSource("com.bernalvarela.dataparser.service.ParserServiceTestFixtures#parseLine")
  void parseLine() {
    assertThat("").isEqualTo("");
  }

  @Test
  void mainExecutor() {
    MainExecutor mainExecutor = new MainExecutor();
    mainExecutor.execute();
  }
}
