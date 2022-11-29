package com.coffee.coffee;

import com.coffee.AbstractCoffeeBatch;
import com.coffee.coffeebean.Arabica;
import com.coffee.coffeestate.CoffeeJar;

public class JacobsSmallJar extends AbstractCoffeeBatch {

    public JacobsSmallJar(double grossWeight) {
        super(32, new CoffeeJar(0.5), new Arabica(), grossWeight);
    }

    public JacobsSmallJar(double unitPrice, double grossWeight) {
        super(unitPrice, new CoffeeJar(0.5), new Arabica(), grossWeight);
    }

    @Override
    public String getName() {
        return "Jarred Jacobs coffee";
    }
}
