package com.kelmerdev.lambdas.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        /*
            * Predicate
            * Recibe un valor y retorna un boolean
        */

        Predicate<String> predicate = (str) -> {
            return str.length() > 5;
        };

        boolean result = predicate.test("Hello World");
        System.out.println(result);


        // Forma Abreviada
        Predicate<String> predicateShort = (str) -> str.length() > 5;
        System.out.println(predicateShort.test("Hello"));
    }
}
