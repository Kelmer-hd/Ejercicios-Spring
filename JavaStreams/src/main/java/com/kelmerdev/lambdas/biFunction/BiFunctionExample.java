package com.kelmerdev.lambdas.biFunction;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        /*
         * BiFunction
         * Recibe dos valores y retorna un valor
         */

        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> {
            return a + b;
        };

        int result = biFunction.apply(10, 20);
        System.out.println(result);


        // Forma Abreviada
        BiFunction<Integer, Integer, Integer> biFunctionShort = (a, b) -> a + b;
        System.out.println(biFunctionShort.apply(20, 30));
    }
}
