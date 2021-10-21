package com.ailleron.translation.client.controller;

import org.springframework.core.io.Resource;

import java.util.Objects;
import java.util.Optional;

public class ResourceFile {
  static final String FILE_EXTENSION = ".properties";

  static final String LANGUAGE_SEPARATOR = "_";

  private String name;

  private Resource file;

  private Optional<String> language;

  ResourceFile(Resource file) {
    name = file.getFilename();
    language = getLanguage(Objects.requireNonNull(file.getFilename()));
    this.file = file;
  }

  public String getName() {
    return name;
  }

  public Optional<String> getLanguage() {
    return language;
  }

  public Resource getResource() {
    return file;
  }

  private Optional<String> getLanguage(String fileName) {
    String[] s = fileName.replaceAll(FILE_EXTENSION, "").split(LANGUAGE_SEPARATOR);
    if (s.length >= 2) {
      return Optional.of(s[1]);
    }
    return Optional.empty();
  }

}