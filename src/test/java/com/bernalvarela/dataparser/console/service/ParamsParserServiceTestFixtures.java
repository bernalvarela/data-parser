package com.bernalvarela.dataparser.console.service;

import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import com.beust.jcommander.ParameterException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class ParamsParserServiceTestFixtures {

  static Stream<Arguments> parseParamsException() {
    return Stream.of(
        Arguments.of(
            new String[]{"-i", "1565647204351", "-e", "1565733598341", "-h", "Jenyssa"},
            "Log file name",
            ParameterException.class
        ),
        Arguments.of(
            new String[]{"/home/bernal/Descargas/input-file-10000.txt", "-i", "1565647204351", "-e", "1565733598341"},
            "The following option is required: [-h | --hosts]",
            ParameterException.class
        )
    );
  }

  static Stream<Arguments> parseParams() {
    return Stream.of(
      Arguments.of(
          new String[]{"/home/bernal/Descargas/input-file-10000.txt", "-i", "1565647204351", "-e", "1565733598341", "-h", "Jenyssa"},
          ExecutorParams.builder()
              .fileName("/home/bernal/Descargas/input-file-10000.txt")
              .init(1565647204351L)
              .end(1565733598341L)
              .hostNames(List.of("Jenyssa"))
              .build()
      ),
      Arguments.of(
          new String[]{"/home/bernal/Descargas/input-file-10000.txt", "-i", "1565647204351", "-e", "1565733598341", "-h", "   Jenyssa   "},
          ExecutorParams.builder()
              .fileName("/home/bernal/Descargas/input-file-10000.txt")
              .init(1565647204351L)
              .end(1565733598341L)
              .hostNames(List.of("Jenyssa"))
              .build()
      ),
      Arguments.of(
          new String[]{"/home/bernal/Descargas/input-file-10000.txt", "-f", "-h", "Ramondo, Haileen"},
          ExecutorParams.builder()
              .fileName("/home/bernal/Descargas/input-file-10000.txt")
              .follow(true)
              .hostNames(List.of("Ramondo", "Haileen"))
              .build()
      )
    );
  }

}