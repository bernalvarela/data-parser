package com.bernalvarela.dataparser.handler;

import static org.assertj.core.api.Assertions.assertThat;

import com.bernalvarela.dataparser.entity.ConnectionInfo;
import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import java.lang.reflect.Field;
import java.util.Map;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Log4j2
public class FollowHandlerTest {

  @ParameterizedTest
  @MethodSource("com.bernalvarela.dataparser.handler.FollowHandlerTestFixtures#followHandlerValues")
  void followHandlerTest(
      ExecutorParams executorParams,
      ConnectionInfo connectionInfo,
      String expectedHostnamesConnectedToGivenHost,
      String hostnamesReceivedConnectionsFromGivenHost,
      Map<String, Integer> expectedConnectionsGenerated
  ) {
    FollowHandler followHandler = new FollowHandler();
    followHandler.doLogic(executorParams, connectionInfo);

    assertThat(getStringFieldValue(followHandler, "hostnamesConnectedToGivenHost").trim())
        .isEqualTo(expectedHostnamesConnectedToGivenHost);
    assertThat(getStringFieldValue(followHandler, "hostnamesReceivedConnectionsFromGivenHost").trim())
        .isEqualTo(hostnamesReceivedConnectionsFromGivenHost);
    assertThat(getConnectionsInfoValue(followHandler, "connectionsGenerated")).isEqualTo(expectedConnectionsGenerated);

  }

  private Object getFieldValue(FollowHandler followHandler, String fieldName) throws NoSuchFieldException, IllegalAccessException {
    Field privateStringField;
    privateStringField = FollowHandler.class.getDeclaredField(fieldName);
    privateStringField.setAccessible(true);
    return privateStringField.get(followHandler);
  }

  @SneakyThrows
  private String getStringFieldValue(FollowHandler followHandler, String fieldName) {
    return (String) getFieldValue(followHandler, fieldName);
  }

  @SneakyThrows
  private Map<String, Integer> getConnectionsInfoValue(FollowHandler followHandler, String fieldName) {
    return (Map<String, Integer>) getFieldValue(followHandler, fieldName);
  }
}
