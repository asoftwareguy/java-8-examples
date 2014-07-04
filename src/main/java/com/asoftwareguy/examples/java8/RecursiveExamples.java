package com.asoftwareguy.examples.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class RecursiveExamples {

    private static BiFunction<Integer, Number[], Number> sum = (index, array) -> {
        if (index == array.length) {
            return 0;
        } else {
            // RecursiveExamples.sum.apply() is required, otherwise "illegal forward reference"
            return new BigDecimal(array[index].floatValue()).add(new BigDecimal(RecursiveExamples.sum.apply(index + 1, array).floatValue()));
        }
    };

    public static void main(String... args) {
        List<Number> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            numbers.add(i);
        });

        Number total = sum.apply(0, numbers.toArray(new Number[numbers.size()]));
        System.out.println(total);
    }
}