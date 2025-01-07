package com.kelmerdev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo title es requerido")
    @Column(nullable = false)
    private  String title;

    @NotBlank(message = "El campo author es requerido")
    @Column(nullable = false)
    private String author;

    @NotBlank(message = "El campo isbn es requerido")
    @Column(nullable = false, unique = true)
    private String isbn;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate published;
}
