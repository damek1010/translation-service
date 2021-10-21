package com.ailleron.translation.controller;

import com.ailleron.translation.api.dto.DictionariesDTO;
import com.ailleron.translation.api.dto.DictionaryVersionsDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("dictionaries")
public class DictionaryController {

  @GetMapping
  @ApiOperation(value = "Get dictionaries",
    produces = "application/json", response = DictionariesDTO.class)
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Dictionary instances")
  })
  public ResponseEntity<DictionariesDTO> getDictionaries(@RequestParam(value = "product", required = false) List<String> product,
                                                         @RequestParam(value = "language", required = false) List<String> language) {

    return ResponseEntity.ok().build();
  }

  @GetMapping("/versions")
  @ApiOperation(value = "Get dictionary versions",
    produces = "application/json", response = DictionariesDTO.class)
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Dictionary instances")
  })
  public ResponseEntity<DictionaryVersionsDTO> getDictionarieVerions(
    @RequestParam(value = "product", required = false) List<String> product,
    @RequestParam(value = "language", required = false) List<String> language) {

    return ResponseEntity.ok().build();
  }

  @GetMapping("{product}/label")
  @ApiOperation(value = "Get dictionary versions",
    produces = "application/json", response = DictionariesDTO.class)
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Dictionary instances")
  })
  public ResponseEntity<DictionaryVersionsDTO> getDictionarieVerions(@PathVariable(value = "product") String product,
                                                                     @RequestParam(value = "label", required = false) List<String> label,
                                                                     @RequestParam(value = "language", required = false) List<String> language) {

    return ResponseEntity.ok().build();
  }

}
