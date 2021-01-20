package com.bernalvarela.dataparser.console.executor;

import com.bernalvarela.dataparser.console.service.ParamsParserService;
import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import com.bernalvarela.dataparser.handler.FollowHandler;
import com.bernalvarela.dataparser.handler.NoFollowHandler;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConsoleExecutor {

  public void execute(String[] args) {
    ExecutorParams executorParams = new ParamsParserService().parseParams(args);
    if (!executorParams.isFollow()) {
      log.info("NoFollowExecutor");
      new NoFollowHandler().execute(executorParams);
    } else {
      log.info("FollowExecutor");
      new FollowHandler().execute(executorParams);
    }
  }

}
