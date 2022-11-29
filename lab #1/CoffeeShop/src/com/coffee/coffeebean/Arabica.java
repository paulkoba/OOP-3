package com.coffee.coffeebean;

import com.coffee.AbstractCoffeeBean;

public class Arabica extends AbstractCoffeeBean {
    public Arabica() {
        setGrainMass(0.004);
    }

    public Arabica(double mass) {
        setGrainMass(mass);
    }

    @Override
    public String getName() {
        return "Arabica";
    }
}
