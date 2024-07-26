package org.advancedJavaProgramming.chapter9.streampipeline;

import java.util.HashSet;
import java.util.Set;

public class Developer {
  private final String name;
  private final Set<String> languages;

  public Developer(String name) {
    this.name = name;
    this.languages = new HashSet<>();
  }

  public void add(String language) {
    this.languages.add(language);
  }

  public Set<String> getLanguages() {
    return languages;
  }
}
