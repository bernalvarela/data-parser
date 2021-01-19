package com.bernalvarela.dataparser.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.bernalvarela.dataparser.executor.ConsoleExecutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ParserServiceTest {

  @ParameterizedTest
  @MethodSource("com.bernalvarela.dataparser.service.ParserServiceTestFixtures#parseLine")
  void parseLine() {
    assertThat("").isEqualTo("");
  }

  @Test
  void consoleExecutor() {
    ConsoleExecutor consoleExecutor = new ConsoleExecutor();
    String[] params = {"/home/bernal/Descargas/input-file-10000.txt", "-i", "1565647204351", "-e", "1565733598341", "-h", "Jenyssa"};
    consoleExecutor.execute(params);
  }

  @Test
  void consoleExecutorUnlimited() {
    ConsoleExecutor consoleExecutor = new ConsoleExecutor();
    String[] params = {"/home/bernal/Descargas/input-file-10000.txt", "-f", "-h", "Ramondo, Haileen"};
    consoleExecutor.execute(params);
  }
}
