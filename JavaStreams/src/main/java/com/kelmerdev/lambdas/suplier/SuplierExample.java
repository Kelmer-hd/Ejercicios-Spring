package com.kelmerdev.lambdas.suplier;

import java.util.function.Supplier;

public class SuplierExample {
    public static void main(String[] args) {
        /*
            * Supplier
            * No recibe valores y retorna un valor
        */

        Supplier<String> supplier = () -> {
            return "Hola soy un Supplier";
        };

        String result = supplier.get();
        System.out.println(result);


        // Forma Abreviada
        Supplier<String> supplierShort = () -> "Hola soy un Supplier";

        // Forma Abreviada
        System.out.println(supplierShort.get());
    }
}
