package com.coffee.coffee;

import com.coffee.AbstractCoffeeBatch;
import com.coffee.coffeebean.Robusta;
import com.coffee.coffeestate.InstantCoffee;

public class TheGrandInstantCoffee extends AbstractCoffeeBatch {

    public TheGrandInstantCoffee(double grossWeight) {
        super(1, new InstantCoffee(0.020), new Robusta(), grossWeight);
    }

    public TheGrandInstantCoffee(double unitPrice, double grossWeight) {
        super(unitPrice, new InstantCoffee(0.020), new Robusta(), grossWeight);
    }

    @Override
    public String getName() {
        return "The Grand Instant Coffee";
    }
}
