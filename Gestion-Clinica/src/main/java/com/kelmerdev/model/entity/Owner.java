package com.kelmerdev.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String phone;
    private String address;
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;
}
