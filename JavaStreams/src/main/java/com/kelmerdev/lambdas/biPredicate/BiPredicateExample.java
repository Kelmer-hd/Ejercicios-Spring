package com.kelmerdev.lambdas.biPredicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        /*
         * BiPredicate
         * Recibe dos valores y retorna un boolean
         */

        BiPredicate<Integer, Integer> biPredicate = (a, b) -> {
            return a > b;
        };

        boolean result = biPredicate.test(10, 20);
        System.out.println(result);


        // Forma Abreviada
        BiPredicate<Integer, Integer> biPredicateShort = (a, b) -> a > b;
        System.out.println(biPredicateShort.test(20, 10));
    }

}
