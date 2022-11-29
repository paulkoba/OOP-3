package com.coffee.coffee;

import com.coffee.AbstractCoffeeBatch;
import com.coffee.coffeebean.Arabica;
import com.coffee.coffeestate.GrainCoffee;

public class SuspiciousGrain extends AbstractCoffeeBatch {

    public SuspiciousGrain(double grossWeight) {
        super(80, new GrainCoffee(1.0), new Arabica(0.0425), grossWeight);
    }

    public SuspiciousGrain(double unitPrice, double grossWeight) {
        super(unitPrice, new GrainCoffee(1.0), new Arabica(0.0425), grossWeight);
    }

    @Override
    public String getName() {
        return "The Suspicious Grain";
    }
}
