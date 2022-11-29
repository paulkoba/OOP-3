package com.coffee.coffeeshop;

import com.coffee.coffee.TheGrandInstantCoffee;
import com.coffeeshop.CoffeeShop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeShopTest {
    @Test
    void testRegisterCoffeeBatch() {
        CoffeeShop cs = new CoffeeShop();

        cs.registerCoffeeBatch(new TheGrandInstantCoffee(35));
        cs.registerCoffeeBatch(new TheGrandInstantCoffee(45));
        cs.registerCoffeeBatch(new TheGrandInstantCoffee(55));

        assertEquals(cs.getBatches().size(), 3);
        assertEquals(cs.getBatches().get(0).getWeight(), 35);
        assertEquals(cs.getBatches().get(1).getWeight(), 45);
        assertEquals(cs.getBatches().get(2).getWeight(), 55);
    }

    @Test
    void testSelectBasedOnPredicate() {
        CoffeeShop cs = new CoffeeShop();

        assertTrue(cs.filter(e -> false).isEmpty());
        assertTrue(cs.filter(e -> true).isEmpty());

        cs.registerCoffeeBatch(new TheGrandInstantCoffee(35));
        assertTrue(cs.filter(e -> false).isEmpty());
        assertFalse(cs.filter(e -> true).isEmpty());

        assertTrue(cs.filter(e -> true).contains(cs.getBatches().get(0)));
    }

    @Test
    void testSelectBasedOnPricePerKG() {
        CoffeeShop cs = new CoffeeShop();

        cs.registerCoffeeBatch(new TheGrandInstantCoffee(35));

        assertFalse(cs.filterBasedOnMassPriceRatio(0, 100).isEmpty());
        assertTrue(cs.filterBasedOnMassPriceRatio(0, 10).isEmpty());

        assertTrue(cs.filterBasedOnMassPriceRatio(0, 100).contains(cs.getBatches().get(0)));
    }
}