package com.coffee.coffeestate;

import com.coffee.AbstractCoffeeState;

public class CoffeeJar extends AbstractCoffeeState {
    public CoffeeJar(double unitSize) {
        super(unitSize);
    }

    @Override
    public String getName() {
        return "Coffee Jar";
    }
}
