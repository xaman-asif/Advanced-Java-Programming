package org.advancedJavaProgramming.chapter9.streampipeline;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class LazyOps {
  public static void main(String[] args) {

    Stream<UUID> uuidStream = Stream.generate(() -> UUID.randomUUID());

    List<String> tenUUIDs =
        uuidStream
            .peek(uuid -> System.out.println("before: " + uuid))
            .skip(3)
            .map(UUID::toString)
            .map(String::toUpperCase)
            .map(uuid -> uuid.replace("-", " "))
            .peek(uuid -> System.out.println("after: " + uuid))
            .limit(5).toList();

  }
}
