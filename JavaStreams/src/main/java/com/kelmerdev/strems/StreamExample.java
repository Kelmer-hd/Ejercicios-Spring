package com.kelmerdev.strems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        /*
         * Stream
         * Secuencia de elementos que soporta operaciones secuenciales y paralelas
         */

        List<String> names = Arrays.asList("Kelmer", "Jhon", "Doe", "Jane", "Mary", "Zack");

        // ForEach es un operador final por que ya no se puede hacer nada despues de el
        names.stream()
                .forEach((name) -> {
                    System.out.println(name);
                });

        // Forma Abreviada
        System.out.println(" -------------- Forma Abreviada --------------");
        names.stream()
                .forEach(System.out::println);


        System.out.println(" -------------- Filter --------------");
        // Filter(): Filtra los elementos que cumplan una condicion.
        names.stream()
                .filter((name) -> {
                    return name.length() > 4;
                })
                .forEach(System.out::println);


        // Operador Map(): Transformar los elementos aplicando una función
        System.out.println(" -------------- Map --------------");
        names.stream()
                .map((name) -> {
                    return name.toUpperCase();
                }).forEach(System.out::println);
        // Forma Abreviada
        System.out.println(" -------------- Map Forma Abreviada --------------");
        names.stream()
                .map(String::toUpperCase)
                .filter((name) -> name.startsWith("A"))
                .forEach(System.out::println);

        // Sorted(): Ordena los elementos
        System.out.println(" -------------- Sorted --------------");
        names.stream()
                .sorted()
                .forEach(System.out::println);


        // ForEach es un operador final por que ya no se puede hacer nada despues de el
        System.out.println(" -------------- ForEach --------------");
        names.stream()
                .forEach((name) -> {
                    // Consultas  a base de datos
                    // Llamadas a servicios
                    // Llamadas a servicios REST
                    // Llamadas a servicios SOAP
                    // Llamadas a servicios GraphQL
                    // Llamadas a servicios gRPC

                    System.out.println(name);
                });


        // Reduce(): Reduce los elementos a un solo valor
        System.out.println(" -------------- Reduce --------------");
        String result = names.stream()
                .reduce("Resultado", (a, b) -> {
                    return a + " " + b;
                });

        System.out.println(result);

        // Forma Abreviada
        System.out.println(" -------------- Reduce Forma Abreviada --------------");
        String resultShort = names.stream()
                .reduce("Resultado", (a, b) -> a + " " + b);
        System.out.println(resultShort);


        // Collect(): Recolecta los elementos en una coleccion
        System.out.println(" -------------- Collect --------------");
        List<String> result1 = names.stream().
                map((name) -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(result1);


        // distinct(): Elimina los elementos duplicados
        System.out.println(" -------------- distinct --------------");
        names.stream()
                .distinct()
                .forEach(System.out::println);


        // limit(): Limita el numero de elementos procesados
        System.out.println(" -------------- limit --------------");
        names.stream()
                .limit(3)
                .forEach(System.out::println);


        // skip(): Salta los primeros n elementos
        System.out.println(" -------------- skip --------------");
        names.stream()
                .skip(3)
                .forEach(System.out::println);


        // anyMatch(): Retorna true si alguno de los elementos cumple con la condición
        System.out.println(" -------------- anyMatch --------------");
        boolean resultAnyMatch = names.stream()
                .anyMatch((name) -> {
                    return name.startsWith("J");
                });
        System.out.println(resultAnyMatch);



        // allMatch(): Retorna true si todos los elementos cumplen con la condición
        System.out.println(" -------------- allMatch --------------");
        boolean resultAllMatch = names.stream()
                .allMatch((name) -> {
                    return name.length() > 3;
                });
        System.out.println(resultAllMatch);


        // noneMatch(): Retorna true si ninguno de los elementos cumple con la condición
        System.out.println(" -------------- noneMatch --------------");
        boolean resultNoneMatch = names.stream()
                .noneMatch((name) -> {
                    return name.length() > 10;
                });
        System.out.println(resultNoneMatch);




    }



}
