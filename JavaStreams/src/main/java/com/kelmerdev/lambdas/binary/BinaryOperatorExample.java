package com.kelmerdev.lambdas.binary;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        /*
            * BinaryOperator
            * Recibe dos valores del mismo tipo y retorna un valor del mismo tipo
        */

        BinaryOperator<Integer> binaryOperator = (a, b) -> {
            return a + b;
        };

        int result = binaryOperator.apply(10, 20);
        System.out.println(result);


        // Forma Abreviada
        BinaryOperator<Integer> binaryOperatorShort = (a, b) -> a + b;
        System.out.println(binaryOperatorShort.apply(20, 30));
    }
}
