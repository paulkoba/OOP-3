package com.coffee.coffee;

import com.coffee.AbstractCoffeeBatch;
import com.coffee.coffeebean.Arabica;
import com.coffee.coffeestate.GroundCoffee;

public class TheMostGroundedCoffee extends AbstractCoffeeBatch {

    public TheMostGroundedCoffee(double grossWeight) {
        super(150, new GroundCoffee(1.0), new Arabica(), grossWeight);
    }

    public TheMostGroundedCoffee(double unitPrice, double grossWeight) {
        super(unitPrice, new GroundCoffee(1.0), new Arabica(), grossWeight);
    }

    @Override
    public String getName() {
        return "The Most Grounded Coffee";
    }
}
