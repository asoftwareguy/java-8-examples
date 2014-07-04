package com.asoftwareguy.examples.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class OptionalExamples {

    public static void main(String... args) {
        // create some Things
        List<Thing> lotsOfThings = new ArrayList<>();
        IntStream.rangeClosed(1, 10000).forEach(i -> {
            Thing newThing = new Thing("" + i, "Description " + i);
            lotsOfThings.add(newThing);
        });

        Optional<Thing> maybeAThing;
        String thingToFind;

        // find a thing (the thing is in the list)
        thingToFind = "6789";
        maybeAThing = findThingByName(thingToFind, lotsOfThings);
        if(maybeAThing.isPresent()) {
            Thing isAThing = maybeAThing.get();
            System.out.println(isAThing);
            // prints "name: 6789, description: Description 6789"
        }

        // find a thing (the thing is NOT in the list)
        thingToFind = "12345678";
        maybeAThing = findThingByName(thingToFind, lotsOfThings);
        if(!maybeAThing.isPresent()) {
            System.out.println("thing not found!");
        }
        // prints "thing not found!"

        // Optional<T> also has methods that take Consumer and Supplier objects,
        // which allow us to pass functional interfaces (lambda expressions)
        thingToFind = "1111";
        maybeAThing = findThingByName(thingToFind, lotsOfThings);
        maybeAThing.ifPresent(System.out::println);
        // prints "name: 1111, description: Description 1111"

        thingToFind = "5434";
        maybeAThing = findThingByName(thingToFind, lotsOfThings);
        Thing alwaysAThing = maybeAThing.orElseGet(() -> new Thing("10000", "New Thing"));
        System.out.println(alwaysAThing);
        // prints "name: 5434, description: Description 5434"

        // this also represent a lambda expression that "closes over" a variable in its
        // lexical scope, also sometimes called a "closure"
        final String closedOverThingToFind = "99999";
        maybeAThing = findThingByName(closedOverThingToFind, lotsOfThings);
        alwaysAThing = maybeAThing.orElseGet(() -> {
            Thing t = new Thing(closedOverThingToFind, "Description " + closedOverThingToFind);
            lotsOfThings.add(t);
            return t;
        });
        System.out.println(alwaysAThing);
        // prints "name: 99999, description: Description 99999"

        // the new Stream API also uses some Optional<T>
        Stream<Thing> streamOfThings = lotsOfThings.stream();
        Optional<Thing> firstThing = streamOfThings.findFirst();
        firstThing.ifPresent(System.out::println);
        // prints "name: 1, description: Description 1"

        streamOfThings = lotsOfThings.stream();
        Optional<Thing> maxThingByName = streamOfThings.max(Comparator.comparing(Thing::getName));
        maxThingByName.ifPresent(System.out::println);
        // prints "name: 99999, description: Description 99999"
    }

    private static Optional<Thing> findThingByName(String name, List<Thing> things) {
        for (Thing thing : things) {
            if (thing.getName().equals(name)) {
                return Optional.of(thing);
            }
        }
        return Optional.empty();
    }
}