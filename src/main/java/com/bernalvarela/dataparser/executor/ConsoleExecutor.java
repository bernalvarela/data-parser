package com.bernalvarela.dataparser.executor;

import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import com.bernalvarela.dataparser.handler.FollowHandler;
import com.bernalvarela.dataparser.handler.NoFollowHandler;
import com.beust.jcommander.JCommander;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConsoleExecutor {

  public void execute(String[] args) {
    ExecutorParams executorParams = new ExecutorParams();
    JCommander.newBuilder()
        .addObject(executorParams)
        .build()
        .parse(args);
    if (!executorParams.isFollow()) {
      log.info("NoFollowExecutor");
      new NoFollowHandler().execute(executorParams);
    } else {
      log.info("FollowExecutor");
      new FollowHandler().execute(executorParams);
    }
  }

}
