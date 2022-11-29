package com.coffeeshop;

import com.coffee.AbstractCoffeeBatch;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CoffeeShop {
    public ArrayList<AbstractCoffeeBatch> getBatches() {
        return batches;
    }

    private final ArrayList<AbstractCoffeeBatch> batches;

    public CoffeeShop() {
        batches = new ArrayList<>();
    }

    public void registerCoffeeBatch(AbstractCoffeeBatch coffee) {
        batches.add(coffee);
    }
    public ArrayList<AbstractCoffeeBatch> filter(Predicate<AbstractCoffeeBatch> predicate) {
        ArrayList<AbstractCoffeeBatch> result = new ArrayList<>();

        for(AbstractCoffeeBatch b : batches) {
            if(predicate.test(b)) {
                result.add(b);
            }
        }

        return result;
    }

    public ArrayList<AbstractCoffeeBatch> filterBasedOnMassPriceRatio(double min, double max) {
        return filter(b -> min < b.getPricePerKG() && b.getPricePerKG() < max);
    }
}
