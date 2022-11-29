package com.coffee;

public abstract class AbstractCoffeeBatch {
    protected double unitPrice;
    protected AbstractCoffeeState state;

    protected AbstractCoffeeBean type;
    protected double weight;

    public double getUnitPrice() {
        return unitPrice;
    }

    protected void setUnitPrice(double unitPrice) {
        if(unitPrice < 0) {
            throw new IllegalArgumentException("Argument out of range");
        }

        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return getWeight() / state.getUnitSize() * getUnitPrice();
    }

    public AbstractCoffeeState getState() {
        return state;
    }

    public double getPricePerKG() { return getTotalPrice() / getWeight(); }
    protected void setState(AbstractCoffeeState state) {
        this.state = state;
    }

    public double getWeight() {
        return weight;
    }

    protected void setWeight(double weight) {
        if(weight < 0) {
            throw new IllegalArgumentException("Argument out of range");
        }

        this.weight = weight;
    }

    public AbstractCoffeeBean getType() {
        return type;
    }

    protected void setType(AbstractCoffeeBean type) {
        this.type = type;
    }

    public abstract String getName();

    public double getUnitSize() { return state.getUnitSize(); }

    public AbstractCoffeeBatch(double unitPrice, AbstractCoffeeState state, AbstractCoffeeBean type, double weight) {
        setUnitPrice(unitPrice);
        setState(state);
        setType(type);
        setWeight(weight);
    }

    @Override
    public String toString() {
        return getName() + ", " + state.getName() + ", " + type.getName() + ", unit price: " + unitPrice + ", unit weight: " + state.getUnitSize() + ", total weight: " + weight ;
    }
}
