package com.asoftwareguy.examples.java8;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

class Thing {

    private final String name;
    private final Integer age;
    private final String description;
    private BigDecimal price;

    public Thing(String name, String description) {
        this.name = name;
        this.description = description;
        this.age = new Random().nextInt();
    }

    {
        this.price = new BigDecimal(new DecimalFormat("####0.00").format(new Random().nextDouble()));
    }

    public String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    public Integer getAge() {
        return age;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "name: " + getName() + ", " + "description: " + getDescription() + ", " + "age: " + getAge() + ", " + "price: $" + getPrice();
    }
}