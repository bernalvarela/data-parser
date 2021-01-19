package com.bernalvarela.dataparser.executor;

import com.bernalvarela.dataparser.entity.ConnectionInfo;
import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class NoFollowExecutor extends MainExecutor{

  @Override
  public void doLogic(ExecutorParams executorParams, ConnectionInfo connectionInfo) {
    if (executorParams.getInit() <= connectionInfo.getTimestamp() &&
        executorParams.getEnd() >= connectionInfo.getTimestamp() &&
        executorParams.getHostNames().get(0).equals(connectionInfo.getDestinationHost())
    ) {
      log.info(connectionInfo.getOriginHost());
    }
  }

}
