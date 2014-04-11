package com.asoftwareguy.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExamples {

    public static void main(String... args) {

        Function<String, Integer> f1 = (String a) -> 1;
        Integer r1 = f1.apply("abc123");
        System.out.println(r1); //prints "1"

        Function<Integer, List<Character>> f2 = (Integer a) -> new ArrayList<>();

        Function<String, List<Character>> f3 = f1.andThen(f2);
        List<Character> r3 = f3.apply("abc123");
        r3.forEach(c -> System.out.println(c)); //prints nothing since f2 doesn't act upon it's input

        // f2.andThen(f1);  //fails type checking
    }
}