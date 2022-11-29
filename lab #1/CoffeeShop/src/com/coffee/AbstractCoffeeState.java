package com.coffee;

public abstract class AbstractCoffeeState {
    private final double unitSize;
    protected AbstractCoffeeState(double unitSize) {
        this.unitSize = unitSize;
    }
    public abstract String getName();
    public double getUnitSize() {
        return unitSize;
    }
}
