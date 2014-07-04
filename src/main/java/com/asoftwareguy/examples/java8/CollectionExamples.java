package com.asoftwareguy.examples.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

class CollectionExamples {

    public static void main(String... args) {
        // create some Things
        List<Thing> lotsOfThings = new ArrayList<>();
        IntStream.rangeClosed(1, 10000).forEach(i -> {
            Thing newThing = new Thing("" + i, "Description " + i);
            lotsOfThings.add(newThing);
        });

        lotsOfThings.forEach(System.out::println);

        // remove even named Things
        Predicate<Thing> evenNamedThing = (Thing thing) -> Integer.parseInt(thing.getName()) % 2 == 0;
        lotsOfThings.removeIf(evenNamedThing);

        lotsOfThings.forEach(System.out::println);
    }
}