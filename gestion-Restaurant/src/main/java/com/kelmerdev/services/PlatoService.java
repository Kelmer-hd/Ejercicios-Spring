package com.kelmerdev.services;

import com.kelmerdev.entity.Plato;
import com.kelmerdev.exception.ResourceNotFoundException;
import com.kelmerdev.repository.PlatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatoService {
    private final PlatoRepository repository;

    public List<Plato> getAll() {
        return repository.findAll();
    }

    public Plato getById(Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Plato save(Plato plato) {
        return repository.save(plato);
    }

    public Plato update(Long id, Plato plato) {
        Plato old = getById(id);
        old.setNombre(plato.getNombre());
        old.setPrecio(plato.getPrecio());
        old.setCategoria(plato.getCategoria());
        old.setEstado(plato.getEstado());
        old.setIngredientes(plato.getIngredientes());
        old.setTiempo(plato.getTiempo());
        return repository.save(old);
    }

    public void delete(Long id) {
        Plato plato = getById(id);
        repository.deleteById(plato.getId());
    }
}
