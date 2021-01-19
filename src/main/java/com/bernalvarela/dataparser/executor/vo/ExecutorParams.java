package com.bernalvarela.dataparser.executor.vo;

import com.bernalvarela.dataparser.converter.StringConverter;
import com.beust.jcommander.Parameter;
import java.util.List;
import lombok.Data;

@Data
public class ExecutorParams {

  @Parameter(required = true, description = "Log file name")
  private String fileName;

  @Parameter(names = {"-f", "--follow"}, description = "Shows content when file is updated")
  private boolean follow;

  @Parameter(names = {"-i", "--init"}, description = "Init datetime")
  private long init;

  @Parameter(names = {"-e", "--end"}, description = "End datetime")
  private long end;

  @Parameter(names = {"-h", "--hosts"}, description = "List of hosts", required = true, converter = StringConverter.class)
  private List<String> hostNames;
}
