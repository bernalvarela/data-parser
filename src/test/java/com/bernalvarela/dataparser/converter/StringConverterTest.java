package com.bernalvarela.dataparser.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringConverterTest {

  @ParameterizedTest
  @ValueSource(strings = {"StringValue", " StringValue ", " StringValue", "StringValue "})
  void testConverter(String value) {
    StringConverter converter = new StringConverter();
    assertThat(converter.convert(value)).isEqualTo(value.trim());
  }
}
