package com.bernalvarela.dataparser.handler;

import com.bernalvarela.dataparser.entity.ConnectionInfo;
import com.bernalvarela.dataparser.executor.vo.ExecutorParams;
import com.bernalvarela.dataparser.service.ParserService;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public abstract class MainHandler {

  public void execute(ExecutorParams executorParams) {
    ParserService parserService = new ParserService();
    try {
      FileInputStream fstream = new FileInputStream(executorParams.getFileName());
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String st;
      while (true) {
        st = br.readLine();
        if (Objects.isNull(st)) {
          if (!executorParams.isFollow()) {
            break;
          } else {
            doLogic(executorParams, null);
          }
        } else {
          doLogic(executorParams,  parserService.parseLine(st));
        }
      }
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

  public abstract void doLogic(ExecutorParams executorParams, ConnectionInfo connectionInfo);

}
