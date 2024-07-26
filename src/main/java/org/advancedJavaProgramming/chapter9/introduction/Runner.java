package org.advancedJavaProgramming.chapter9.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

  public static String findEnglishBooks(List<Book> books) {
    List<Book> englishBooks = new ArrayList<>();

    for (Book book : books) {
      if (book.getLanguage().equals("English") && book.getPrice() >= 500 && book.getPrice() <= 1000) {
        englishBooks.add(book);
      }
    }

    Collections.sort(englishBooks, new Comparator<Book>() {
      @Override
      public int compare(Book o1, Book o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
      }
    });

    final String comma = ",";

    StringBuilder bookBuilder = new StringBuilder();

    for (Book englishBook : englishBooks) {
      bookBuilder.append(englishBook.toString()).append(comma);
    }

    return bookBuilder.toString();
  }
}
