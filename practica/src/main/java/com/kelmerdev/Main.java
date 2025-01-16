package com.kelmerdev;

public class Main {
    public static void main(String[] args) {
        /*
        📝 Problema: Invertir una cadena de texto: "Hola Mundo"
         */

        /*
            1. Enfoque Imperativo (Usando for):
            En la programación imperativa, nos centramos en cómo lograr el resultado paso a paso especificando las instrucciones que deben ejecutarse.
        */

        String input = "Hola Mundo";
        String result = "";

        for (int i = input.length() - 1; i >= 0; i--){
            result += input.charAt(i);
        }
        System.out.println(result); // odnuM aloH

        /*
            2. Enfoque Declarativo (Usando String):
            La programación declarativa, por otro lado, se enfoca en qué queremos lograr en lugar de cómo hacerlo. Podemos lograr el mismo resultado de manera más concisa.
        */
        String input2 = "Hola Mundo";
        String result2 = new StringBuilder(input2).reverse().toString();
        System.out.println(result2); // odnuM aloH

    }
}