package org.advancedJavaProgramming.chapter7.decoratorpattern.lambdaImplementation;

import java.util.function.Function;
import org.advancedJavaProgramming.chapter7.decoratorpattern.Coffee;

public class CoffeeDecoratorUsingLambda {
  public static Coffee getCoffeeWithExtras(Coffee coffee, Function<Coffee, Coffee>... ingredients) {
    Function<Coffee, Coffee> initial = kopi -> kopi;

    for (Function<Coffee, Coffee> ingredient : ingredients) {
      initial = initial.andThen(ingredient);
    }

    return initial.apply(coffee);
  }
}
