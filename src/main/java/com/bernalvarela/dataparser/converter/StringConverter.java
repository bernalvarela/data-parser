package com.bernalvarela.dataparser.converter;

import com.beust.jcommander.IStringConverter;

public class StringConverter implements IStringConverter<String> {

  @Override
  public String convert(String value) {
    return value.trim();
  }

}
