package com.coffee.coffeestate;

import com.coffee.AbstractCoffeeState;


public class GroundCoffee extends AbstractCoffeeState {
    public GroundCoffee(double unitSize) {
        super(unitSize);
    }

    @Override
    public String getName() {
        return "Ground Coffee";
    }
}
