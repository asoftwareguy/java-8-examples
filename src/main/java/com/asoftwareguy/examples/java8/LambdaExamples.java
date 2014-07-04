package com.asoftwareguy.examples.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LambdaExamples {

    public static void main(String... args) {
        // create some Things
        List<Thing> things = new ArrayList<>();
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Thing newThing = new Thing("" + i, "Description " + i);
            things.add(newThing);
        });

        // print out only things that pass the predicate
        doWithThingsThatMatch(things,
                thing -> Integer.parseInt(thing.getName()) <= 5,
                System.out::println
        );
    }

    public static void doWithThingsThatMatch(List<Thing> things, Predicate<Thing> predicate, Consumer<Thing> consumer) {
        Objects.requireNonNull(things);
        Objects.requireNonNull(predicate);
        things
                .stream()
                .filter(predicate::test)
                .forEach(consumer::accept);
    }
}