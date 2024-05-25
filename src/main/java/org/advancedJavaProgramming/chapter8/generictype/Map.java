package org.advancedJavaProgramming.chapter8.generictype;

public interface Map<K, V> {

  V put(K key, V value);

  K getKey();

  V getValue();
}
