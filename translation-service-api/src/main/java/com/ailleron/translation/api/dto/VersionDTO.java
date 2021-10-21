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
public class VersionDTO {

  @ApiModelProperty(required = true, value = "map of dictionary version with language as key and version as value", reference = "Map")
  Map<String, String> values;

}
