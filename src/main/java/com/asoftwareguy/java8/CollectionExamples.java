package com.asoftwareguy.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CollectionExamples {

    public static void main(String... args) {
        List<Thing> lotsOfThings = new ArrayList<>();

        // create some Things
        IntStream.rangeClosed(1, 10000).forEach(i -> {
            Thing newThing = new Thing("" + i, "Description " + i);
            lotsOfThings.add(newThing);
        });

        lotsOfThings.forEach(thing -> System.out.println(thing));

        // remove even named Things
        Predicate<Thing> evenNamedThing = (Thing thing) -> Integer.parseInt(thing.getName()) % 2 == 0;
        lotsOfThings.removeIf(evenNamedThing);

        lotsOfThings.forEach(thing -> System.out.println(thing));
    }
}