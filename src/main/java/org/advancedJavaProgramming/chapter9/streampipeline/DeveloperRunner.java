package org.advancedJavaProgramming.chapter9.streampipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeveloperRunner {
  public static void main(String[] args) {
    List<Developer> team = new ArrayList<>();

    Developer polygot = new Developer("Developer X");

    polygot.add("clojure");
    polygot.add("scala");
    polygot.add("groovy");
    polygot.add("go");


    Developer busy = new Developer("Developer Y");
    busy.add("java");
    busy.add("javascript");

    team.add(polygot);
    team.add(busy);

    Stream<Set<String>> setStream = team.stream().map(Developer::getLanguages);

    Stream<String> stringStream = setStream.flatMap(language -> language.stream());

    List<String> list = stringStream.collect(Collectors.toList());

    List<String> list2 =
        team.stream().map(Developer::getLanguages).flatMap(language -> language.stream()).toList();
  }
}
