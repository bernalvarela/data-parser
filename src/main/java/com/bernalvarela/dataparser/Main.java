package com.bernalvarela.dataparser;

import com.bernalvarela.dataparser.executor.ConsoleExecutor;
import com.beust.jcommander.ParameterException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

  public static void main(String[] args) {
    try {
      ConsoleExecutor consoleExecutor = new ConsoleExecutor();
      consoleExecutor.execute(args);
    } catch (ParameterException e) {
      log.error(e.getMessage());
    }
  }

}
