package com.coffee;

import com.coffee.coffeestate.CoffeeJar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractCoffeeStateTest {
    @Test
    void abstractCoffeeStateConstruction() {
        AbstractCoffeeState state = new CoffeeJar(1);
        assertEquals(state.getUnitSize(), 1);
        assertEquals(state.getName(), "Coffee Jar");
    }
}