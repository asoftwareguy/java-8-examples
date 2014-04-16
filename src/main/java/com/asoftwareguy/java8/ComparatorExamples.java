package com.asoftwareguy.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ComparatorExamples {

    public static void main(String... args) {
        // create some Things
        List<Thing> lotsOfThings = new ArrayList<>();
        IntStream.rangeClosed(1, 10000).forEach(i -> {
            Thing newThing = new Thing("" + i, "Description " + i);
            lotsOfThings.add(newThing);
        });

        Comparator<Thing> thingComparator =
                Comparator.comparing(Thing::getAge)
                        .thenComparing(Thing::getPrice)
                        .thenComparing(Thing::getName);

        lotsOfThings
                .stream()
                .sorted(thingComparator)
                .forEach(System.out::println);
    }
}