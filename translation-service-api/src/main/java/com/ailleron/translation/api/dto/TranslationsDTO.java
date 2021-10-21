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
public class TranslationsDTO {

  @ApiModelProperty(required = true, value = "map of labels translations for specific dictionary", reference = "Map")
  Map<String, DictionaryDTO> values;

}