package com.kelmerdev.lambdas.unary;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        /*
            * UnaryOperator
            * Recibe un valor lo procesa y devuelve un resultado del mismo tipo
        */

        UnaryOperator<Integer> unaryOperator = (number) -> {
            return number * number;
        };

        int result = unaryOperator.apply(5);
        System.out.println(result);


        // Forma Abreviada
        UnaryOperator<Integer> unaryOperatorShort = (number) -> number * number;
        System.out.println(unaryOperatorShort.apply(10));

    }
}
