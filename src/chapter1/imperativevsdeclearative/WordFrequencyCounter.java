package chapter1.imperativevsdeclearative;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
  static Map<String, Long> countFrequency(List<String> words) {

    Map<String, Long> frequencyMap = new HashMap<>();

    for (String word : words) {
      if (!frequencyMap.containsKey(word)) {
        frequencyMap.put(word, 0L);
      }

      Long oldCount = frequencyMap.get(word);
      frequencyMap.put(word, oldCount + 1);
    }
    return frequencyMap;
  }

  static Map<String, Long> countFrequencyFunctionalWay(List<String> words) {
    Map<String, Long> frequencyMap = new HashMap<>();
    // old value is 0 initially
    // here 1L is value, if it was 2L then value would be 2
    for (String word : words) {
      frequencyMap.merge(word, 1L, (oldValue, value) -> oldValue + value);
    }
    return frequencyMap;
  }

  static Map<String, Long> countFrequency3(List<String> words) {
    return words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static void main(String[] args) {
    List<String> words = Arrays.asList("Hello", "World", "Bangladesh", "Dhaka", "Hello", "Java", "Lambda");

    Map<String, Long> wordFrequency = countFrequency(words);

    System.out.println(wordFrequency);
  }
}
