package com.asoftwareguy.examples.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EnumFunctionExamples {

    public enum ConstructiveIntegerOperators implements BiFunction<Integer, Integer, Integer> {
        PLUS {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        },
        MINUS {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a - b;
            }
        }
    }

    public enum DestructiveIntegerOperators implements Function<Integer, Function<Integer, Integer>> {
        PLUS {
            @Override
            public Function<Integer, Integer> apply(Integer a) {
                return b -> a + b;
            }
        },
        MINUS {
            @Override
            public Function<Integer, Integer> apply(Integer a) {
                return b -> a - b;
            }
        }
    }

    public static void main(String... args) {
        Integer r1 = ConstructiveIntegerOperators.PLUS.apply(3, 3);
        System.out.println(r1);
        // prints "6"

        Integer r2 = ConstructiveIntegerOperators.MINUS.apply(3, 6);
        System.out.println(r2);
        // prints "-3"

        // cannot partially apply a constructive function, compilation error
        // IntegerOperators.PLUS.apply(3);

        Integer r3 = DestructiveIntegerOperators.PLUS.apply(3).apply(3);
        System.out.println(r3);
        // prints "6"

        Integer r4 = DestructiveIntegerOperators.MINUS.apply(3).apply(6);
        System.out.println(r4);
        // prints "-3"

        // can also partially apply the operators
        Function<Integer, Integer> xPlus2 = DestructiveIntegerOperators.PLUS.apply(2);
        Integer r5 = xPlus2.apply(5);
        System.out.println(r5);
        // prints "7"

        Integer r6 = xPlus2.apply(-2);
        System.out.println(r6);
        // prints "0"
    }
}