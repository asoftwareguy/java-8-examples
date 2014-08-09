package com.asoftwareguy.examples.java8.interface_default_method;

public class FooBarClass implements FooBarInterface {

    @Override
    public boolean doFooBar(Foo foo, Bar bar) {
        System.out.println("doFooBar(Foo, Bar)");
        return false;
    }

    public static void main(String[] args) {
        FooBarClass postProcessingClass = new FooBarClass();
        postProcessingClass.doFoo(new Foo());
        postProcessingClass.doFooBar(new Foo(), new Bar());
    }
}
