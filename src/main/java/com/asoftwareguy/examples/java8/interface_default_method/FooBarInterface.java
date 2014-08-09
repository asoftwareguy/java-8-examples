package com.asoftwareguy.examples.java8.interface_default_method;

public interface FooBarInterface extends FooInterface {

    @Override
    public default boolean doFoo(Foo foo) {
        throw new UnsupportedOperationException("bad!");
    }

    public boolean doFooBar(Foo foo, Bar bar);
}