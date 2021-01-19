package com.bernalvarela.dataparser.executor;

import com.bernalvarela.dataparser.service.ParserService;
import com.bernalvarela.dataparser.vo.ConnectionInfoVO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class MainExecutor {

  private static String SPACE = " ";

  public void execute() {
    ParserService parserService = new ParserService();
    File file = new File("/home/bernal/Descargas/input-file-10000.txt");
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String st;
      while (true) {
        if (Objects.isNull(st = br.readLine())) {
          break;
        }
        ConnectionInfoVO connectionInfoVO = parserService.parseLine(st);
        System.out.println(connectionInfoVO.getTimestamp().toString()
            .concat(SPACE)
            .concat(connectionInfoVO.getOriginHost())
            .concat(SPACE)
            .concat(connectionInfoVO.getDestinationHost())
        );
      }
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
