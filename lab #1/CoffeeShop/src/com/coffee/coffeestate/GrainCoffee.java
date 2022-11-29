package com.coffee.coffeestate;

import com.coffee.AbstractCoffeeState;

public class GrainCoffee extends AbstractCoffeeState {
    public GrainCoffee(double unitSize) {
        super(unitSize);
    }

    @Override
    public String getName() {
        return "Grain Coffee";
    }
}
