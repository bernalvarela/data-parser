package com.bernalvarela.dataparser.console.service;

import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import com.beust.jcommander.JCommander;

public class ParamsParserService {

  public ExecutorParams parseParams(String[] args) {
    ExecutorParams executorParams = new ExecutorParams();
    JCommander.newBuilder()
        .addObject(executorParams)
        .build()
        .parse(args);
    return executorParams;
  }
}
