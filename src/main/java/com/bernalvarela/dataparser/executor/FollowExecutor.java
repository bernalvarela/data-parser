package com.bernalvarela.dataparser.executor;

import com.bernalvarela.dataparser.entity.ConnectionInfo;
import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class FollowExecutor extends MainExecutor{

  private long initTime;

  private static final long OUTPUT = 10000;

  private String hostnamesConnectedToGivenHost;

  private String hostnamesReceivedConnectionsFromGivenHost;

  private Map<String, Integer> connectionsGenerated;

  private Integer numberAccess = 0;

  private ConnectionInfo mostAccesedConnectionInfo;

  public FollowExecutor() {
    super();
    initTime = System.currentTimeMillis();
    hostnamesConnectedToGivenHost = "";
    hostnamesReceivedConnectionsFromGivenHost = "";
    connectionsGenerated = new HashMap<>();
    mostAccesedConnectionInfo = null;
  }

  @Override
  public void doLogic(ExecutorParams executorParams, ConnectionInfo connectionInfo) {
    if (Objects.nonNull(connectionInfo)) {
      if (executorParams.getHostNames().get(0).equals(connectionInfo.getDestinationHost())) {
        hostnamesConnectedToGivenHost = hostnamesConnectedToGivenHost.concat(connectionInfo.getOriginHost()).concat(" ");
      }
      if (executorParams.getHostNames().get(1).equals(connectionInfo.getOriginHost())) {
        hostnamesReceivedConnectionsFromGivenHost = hostnamesReceivedConnectionsFromGivenHost
            .concat(connectionInfo.getDestinationHost()).concat(" ");
      }

      if (!connectionsGenerated.containsKey(connectionInfo.getOriginHost())) {
        connectionsGenerated.put(connectionInfo.getOriginHost(), 1);
      } else {
        connectionsGenerated.put(connectionInfo.getOriginHost(), connectionsGenerated.get(connectionInfo.getOriginHost()) + 1);
      }

      if (connectionsGenerated.get(connectionInfo.getOriginHost()) > numberAccess) {
        numberAccess = connectionsGenerated.get(connectionInfo.getOriginHost());
        mostAccesedConnectionInfo = connectionInfo;
      }
    }

    if (System.currentTimeMillis() > initTime + OUTPUT) {
      printElements(executorParams);
      initTime = System.currentTimeMillis();
      hostnamesConnectedToGivenHost = "";
      hostnamesReceivedConnectionsFromGivenHost = "";
      connectionsGenerated = new HashMap<>();
      mostAccesedConnectionInfo = null;
    }
  }

  private void printElements(ExecutorParams executorParams) {
    if (Objects.nonNull(mostAccesedConnectionInfo)) {
      if (!hostnamesConnectedToGivenHost.isEmpty()) {
        log.info("Hostnames connected to {}: {} ", executorParams.getHostNames().get(0), hostnamesConnectedToGivenHost);
      } else {
        log.warn("{} has no hostnames connected to ", executorParams.getHostNames().get(0));
      }

      if (!hostnamesReceivedConnectionsFromGivenHost.isEmpty()) {
        log.info("Hostnames receiving connections from {}: {} ",
            executorParams.getHostNames().get(1),
            hostnamesReceivedConnectionsFromGivenHost
        );
      } else {
        log.warn("{} has not connected to any host ", executorParams.getHostNames().get(1));
      }
      log.info("Hostname {} has generated more connections: {} ", mostAccesedConnectionInfo.getOriginHost(), numberAccess);
    } else {
      log.warn("Log file not updated");
    }
  }
}