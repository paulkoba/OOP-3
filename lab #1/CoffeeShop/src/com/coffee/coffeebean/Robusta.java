package com.coffee.coffeebean;

import com.coffee.AbstractCoffeeBean;

public class Robusta extends AbstractCoffeeBean {
    public Robusta() {
        setGrainMass(0.005);
    }

    public Robusta(double mass) {
        setGrainMass(mass);
    }

    @Override
    public String getName() {
        return "Robusta";
    }
}
