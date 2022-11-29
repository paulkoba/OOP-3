package com.coffee;

public abstract class AbstractCoffeeBean {
    protected double grainMass;

    public abstract String getName();

    public double getGrainMass() {
        return grainMass;
    }

    protected void setGrainMass(double grainMass) {
        if(grainMass < 0) {
            throw new IllegalArgumentException("Argument out of range");
        }

        this.grainMass = grainMass;
    }
}
