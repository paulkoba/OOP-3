package com.coffee;

import com.coffee.coffeebean.Arabica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCoffeeBeanTest {
    @Test
    void testCoffeeTypeCreation() {
        AbstractCoffeeBean type = new Arabica(0.007);
        assertEquals(type.getName(), "Arabica");
        assertEquals(type.getGrainMass(), 0.007);
    }
}