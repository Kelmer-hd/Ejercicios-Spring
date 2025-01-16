package com.kelmerdev.service;

import com.kelmerdev.model.entity.Pet;
import com.kelmerdev.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }



}
