package com.coffeeshop;

import com.coffee.AbstractCoffeeBatch;
import com.coffee.coffee.JacobsSmallJar;
import com.coffee.coffee.SuspiciousGrain;
import com.coffee.coffee.TheGrandInstantCoffee;
import com.coffee.coffee.TheMostGroundedCoffee;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static void listGoods(ArrayList<AbstractCoffeeBatch> batches) {
        batches.sort(Comparator.comparingDouble(AbstractCoffeeBatch::getPricePerKG));

        for(AbstractCoffeeBatch b : batches) {
            System.out.println(b.toString());
        }
    }

    public static void main(String[] args) {
        CoffeeShop shop = new CoffeeShop();

        shop.registerCoffeeBatch(new JacobsSmallJar(25));
        shop.registerCoffeeBatch(new SuspiciousGrain(40));
        shop.registerCoffeeBatch(new SuspiciousGrain(39, 79));
        shop.registerCoffeeBatch(new TheMostGroundedCoffee(39));
        shop.registerCoffeeBatch(new TheGrandInstantCoffee(10));

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Enter action you want to perform:");
                System.out.println("(1) - List all available goods");
                System.out.println("(2) - Select goods based on price per 1 KG");
                System.out.println("(3) - Select available goods by parameter range");
                System.out.println("(0) - Exit");

                int action = scanner.nextInt();
                switch (action) {
                    case 0:
                        System.out.println("Halting...");
                        return;
                    case 1:
                        listGoods(shop.getBatches());
                        break;
                    case 2:
                        System.out.println("Enter price per KG floor:");
                        int floor = scanner.nextInt();
                        System.out.println("Enter price per KG ceiling:");
                        int ceiling = scanner.nextInt();

                        listGoods(shop.filterBasedOnMassPriceRatio(floor, ceiling));
                        break;
                    case 3:
                        System.out.println("Enter total weight floor:");
                        double weightFloor = scanner.nextDouble();
                        System.out.println("Enter total weight ceiling:");
                        double weightCeiling = scanner.nextDouble();

                        System.out.println("Enter unit price floor:");
                        double priceFloor = scanner.nextDouble();
                        System.out.println("Enter unit price ceiling:");
                        double priceCeiling = scanner.nextDouble();

                        System.out.println("Enter unit size floor:");
                        double unitSizeFloor = scanner.nextDouble();
                        System.out.println("Enter unit size ceiling:");
                        double unitSizeCeiling = scanner.nextDouble();

                        listGoods(shop.filter(batch ->
                                weightFloor < batch.getWeight() && batch.getWeight() < weightCeiling &&
                                priceFloor < batch.getUnitPrice() && batch.getUnitPrice() < priceCeiling &&
                                unitSizeFloor < batch.getUnitSize() && batch.getUnitSize() < unitSizeCeiling
                        ));

                        break;
                    default:
                        System.out.println("Unknown operation. Halting...");
                        return;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input provided. Halting...");
        }
    }
}
