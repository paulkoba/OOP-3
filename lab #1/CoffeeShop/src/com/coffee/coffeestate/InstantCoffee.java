package com.coffee.coffeestate;

import com.coffee.AbstractCoffeeState;

public class InstantCoffee extends AbstractCoffeeState {
    public InstantCoffee(double unitSize) {
        super(unitSize);
    }

    @Override
    public String getName() {
        return "Instant Coffee";
    }
}
