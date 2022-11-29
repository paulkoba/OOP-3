package com.coffee;

import com.coffee.coffee.SuspiciousGrain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractCoffeeBatchTest {
    @Test
    void testCoffeeBatchConstruction() {
        AbstractCoffeeBatch batch = new SuspiciousGrain(50,150);

        assertEquals(batch.getWeight(), 150);
        assertEquals(batch.getPricePerKG(), 50);
        assertEquals(batch.getTotalPrice(), 50 * 150 * batch.getUnitSize());

        assertEquals(batch.getType().getName(), "Arabica");

        batch.setWeight(250);
        assertEquals(batch.getWeight(), 250);
    }

    @Test
    void testCoffeeBatchErrorHandling() {
        assertThrows(IllegalArgumentException.class, () -> new SuspiciousGrain(-5));
        assertThrows(IllegalArgumentException.class, () -> new SuspiciousGrain(5).setUnitPrice(-42.0));
    }
}