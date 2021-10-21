package com.ailleron.translation.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor
public class DictionariesDTO {
  @ApiModelProperty(required = true, value = "map of dictionaries with dictionary name as key and translations as value", name = "dictionaries",
    example =
      "{\"product1\":{\"values\":{\"PL\":{\"values\":{\"label1\":\"string\",\"label2\":\"string\",\"label3\":\"string\"}," +
      "\"version\":\"string\"},\"EN\":{\"values\":{\"label1\":\"string\",\"label2\":\"string\",\"label3\":\"string\"},\"version\":\"string\"}}}," +
      "\"product2\":{\"values\":{\"PL\":{\"values\":{\"label1\":\"string\",\"label2\":\"string\",\"label3\":\"string\"},\"version\":\"string\"}," +
      "\"EN\":{\"values\":{\"label1\":\"string\",\"label2\":\"string\",\"label3\":\"string\"},\"version\":\"string\"}}}}")
  Map<String, TranslationsDTO> dictionaries;

} 