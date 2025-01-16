package com.kelmerdev.lambdas.biconsumer;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        /*
            * BiConsumer
            * Recibe dos valores y no retorna nada
        */

        BiConsumer<String, String> biConsumer = (param1, param2) -> {
            System.out.println(param1 + " " + param2);
        };

        // Forma Abreviada
        BiConsumer<String, String> biConsumerShort = (param1, param2) -> System.out.println(param1 + " " + param2);

        biConsumer.accept("Hello", "World");
        biConsumerShort.accept("Hello", "World");
    }
}
