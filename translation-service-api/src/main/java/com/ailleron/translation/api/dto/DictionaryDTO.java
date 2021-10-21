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
public class DictionaryDTO {

  @ApiModelProperty(value = "dictionary version", name = "version")
  private String version;

  @ApiModelProperty(required = true, value = "map of translation with label name as key and label value as value", name = "values")
  private Map<String, String> values;
}
