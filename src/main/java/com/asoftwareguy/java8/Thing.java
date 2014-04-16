package com.asoftwareguy.java8;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

public class Thing {

    private String name;
    private Integer age;
    private String description;
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

    public String getDescription() {
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