package com.kelmerdev.lambdas.callable;

import java.util.concurrent.Callable;

public class CallableExample {
    public static void main(String[] args) {
        /*
            * Callable
            * No recibe valore, pero retorna un res y pude lanzar una excepcion
        */

        Callable<String> callable = () -> {
            return "Resultado de la tarea";
        };

        try {
            String result = callable.call();
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // Forma Abreviada
        Callable<String> callableShort = () -> "Resultado de la tarea";
        try {
            System.out.println(callableShort.call());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
