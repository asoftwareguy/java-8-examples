package com.asoftwareguy.java8;

public class Thing {

    private String name;
    private String description;

    public Thing(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("name: ")
                .append(name)
                .append(", ")
                .append("description: ")
                .append(description)
                .toString();
    }
}