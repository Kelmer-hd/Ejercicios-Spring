package com.kelmerdev.model.dto;

import com.kelmerdev.model.entity.Pet;

import lombok.Data;

import java.util.List;

@Data
public class OwnerDTO {

    private String firstName;
    private String lastName;
    private String dni;
    private String phone;
    private String address;
    private String email;
    private List<Pet> pets;
}
