package com.kelmerdev.services;

import com.kelmerdev.entity.Ingrediente;
import com.kelmerdev.exception.ResourceNotFoundException;
import com.kelmerdev.repository.IngredienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientesService {

    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> findAll() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente findById(Long id) {
        return ingredienteRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Ingrediente save(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public Ingrediente update(Long id, Ingrediente ingrediente) {

        Ingrediente existing = findById(id);
        if (existing != null) {
            existing.setNombre(ingrediente.getNombre());
            existing.setStock(ingrediente.getStock());
            existing.setUnidadMedida(ingrediente.getUnidadMedida());
            existing.setStockMinimo(ingrediente.getStockMinimo());
            existing.setStockMaximo(ingrediente.getStockMaximo());
            return ingredienteRepository.save(existing);
        }

        return null;
    }

    public void delete(Long id) {
        Ingrediente existing = findById(id);
        if (existing != null) {
            ingredienteRepository.delete(existing);
        }
    }
}
