package com.ailleron.translation.controller;

import com.ailleron.translation.api.dto.DictionariesDTO;
import com.ailleron.translation.api.dto.DictionaryDTO;
import com.ailleron.translation.api.dto.DictionaryVersionsDTO;
import com.ailleron.translation.api.dto.TranslationsDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                                                           @RequestParam(value = "language", required = false) List<String> language) throws FileNotFoundException {

        Map<String, TranslationsDTO> dictionaries = Stream.of(ResourceUtils.getFile("classpath:dictionaries/custom/").listFiles())
                .filter(File::isDirectory)
                .filter(file -> {
                    if (product != null)
                        return product.contains(file.getName());

                    return true;
                })
                .map(file -> this.getProductDictionary(file, language))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return ResponseEntity.ok().body(new DictionariesDTO(dictionaries));
    }

    @GetMapping("/versions")
    @ApiOperation(value = "Get dictionary versions",
            produces = "application/json", response = DictionariesDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dictionary instances")
    })
    public ResponseEntity<DictionaryVersionsDTO> getDictionariesVersions(
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

    private Map.Entry<String, TranslationsDTO> getProductDictionary(File directory, List<String> languages) {
            Map<String, DictionaryDTO> translations = Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                    .filter(file -> {
                        if (languages != null)
                            return languages.contains(file.getName().replace(".properties", ""));
                        return true;
                    })
                    .map(this::getTranslationsFromFile)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            return new AbstractMap.SimpleEntry<>(directory.getName(), new TranslationsDTO(translations));

    }

    private Map.Entry<String, DictionaryDTO> getTranslationsFromFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            Map<String, String> values = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split("=");
                String key = keyValue[0];
                String value = keyValue[1];

                values.put(key, value);
            }

            return new AbstractMap.SimpleEntry<>(file.getName().replace(".properties", ""), new DictionaryDTO("1", values));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
