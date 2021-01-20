package com.bernalvarela.dataparser.handler;

import com.bernalvarela.dataparser.entity.ConnectionInfo;
import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class FollowHandlerTestFixtures {

  private static final String RAMONDO = "Ramondo";

  private static final String HAILEEN = "Haileen";

  private static final String SHILLA = "Shilla";

  private static final String EMPTY_STRING = "";

  static Stream<Arguments> followHandlerValues() {
    return Stream.of(
        Arguments.of(
            ExecutorParams.builder().follow(true).hostNames(List.of(HAILEEN, RAMONDO)).build(),
            ConnectionInfo.builder().originHost(RAMONDO).destinationHost(HAILEEN).build(),
            RAMONDO,
            HAILEEN,
            Map.of(RAMONDO, 1)
        ),
        Arguments.of(
            ExecutorParams.builder().follow(true).hostNames(List.of(RAMONDO, HAILEEN)).build(),
            ConnectionInfo.builder().originHost(RAMONDO).destinationHost(HAILEEN).build(),
            EMPTY_STRING,
            EMPTY_STRING,
            Map.of(RAMONDO, 1)
        ),
        Arguments.of(
            ExecutorParams.builder().follow(true).hostNames(List.of(RAMONDO, HAILEEN)).build(),
            ConnectionInfo.builder().originHost(SHILLA).destinationHost(RAMONDO).build(),
            SHILLA,
            EMPTY_STRING,
            Map.of(SHILLA, 1)
        ),
        Arguments.of(
            ExecutorParams.builder().follow(true).hostNames(List.of(RAMONDO, HAILEEN)).build(),
            ConnectionInfo.builder().originHost(HAILEEN).destinationHost(SHILLA).build(),
            EMPTY_STRING,
            SHILLA,
            Map.of(HAILEEN, 1)
        )
    );
  }

}