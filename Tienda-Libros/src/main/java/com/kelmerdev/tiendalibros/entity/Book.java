package com.kelmerdev.tiendalibros.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.File;
import java.util.Date;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;
    private String author;
    private String editorial;
    private String ISBN;
    private String genre;
    private Date published;
    private double purchasePrice;
    private double salePrice;
    private int stock;
    private String storeLocation;
    private File image;
    private String description;

}
