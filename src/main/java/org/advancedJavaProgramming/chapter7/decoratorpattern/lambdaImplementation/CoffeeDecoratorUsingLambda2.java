package org.advancedJavaProgramming.chapter7.decoratorpattern.lambdaImplementation;

import java.util.function.Function;
import java.util.stream.Stream;
import org.advancedJavaProgramming.chapter7.decoratorpattern.Coffee;
import org.advancedJavaProgramming.chapter7.decoratorpattern.preJava8Implementation.CoffeeBean;

public class CoffeeDecoratorUsingLambda2 {
  public static Coffee getCoffeeWithExtras(Coffee coffee, Function<Coffee, Coffee>... ingredients) {

    Function<Coffee, Coffee> reduced = Stream.of(ingredients).reduce(Function.identity(), Function::andThen);

    return reduced.apply(coffee);
  }

  public static void main(String[] args) {
    var coffee = getCoffeeWithExtras(new CoffeeBean(),
        Coffee::withDarkCookieCrumb,
        Coffee::withSweetenedMilk,
        Coffee::withVanillAlmondExtract);

    System.out.println(coffee.getIngredient());
  }
}
