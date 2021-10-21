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
public class DictionaryVersionsDTO {
  @ApiModelProperty(required = true, value = "map of dictionaries with dictionary name as key and translations as value", name = "dictionaries",
    example = "{\"product1\":{\"values\":{\"PL\":\"string\",\"EN\":\"string\"}}," +
              "\"product2\":{\"values\":{\"PL\":\"string\",\"EN\":\"string\"}}}")
  Map<String, VersionDTO> dictionaries;

} 