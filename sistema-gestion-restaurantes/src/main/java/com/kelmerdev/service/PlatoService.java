package com.kelmerdev.service;

import com.kelmerdev.exception.ResourceNotFoundException;
import com.kelmerdev.model.dto.PlatoDTO;
import com.kelmerdev.model.entity.Plato;
import com.kelmerdev.repository.PlatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatoService {

    private final PlatoRepository platoRepository;

    public List<Plato> findAll() {
        return platoRepository.findAll();
    }

    public Plato findById(Long id) {
        return platoRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Plato save(PlatoDTO platoDTO) {
        Plato plato = new Plato();
        plato.setNombre(platoDTO.getNombre());
        plato.setPrecio(platoDTO.getPrecio());
        plato.setCategoria(platoDTO.getCategoria());
        plato.setTiempoPreparacion(platoDTO.getTiempoPreparacion());
        plato.setDisponible(platoDTO.isDisponible());

        return platoRepository.save(plato);
    }

    public Plato update(Long id, PlatoDTO platoDTO) {
        Plato plato = findById(id);
        plato.setNombre(platoDTO.getNombre());
        plato.setPrecio(platoDTO.getPrecio());
        plato.setCategoria(platoDTO.getCategoria());
        plato.setTiempoPreparacion(platoDTO.getTiempoPreparacion());
        plato.setDisponible(platoDTO.isDisponible());

        return platoRepository.save(plato);
    }

    public void delete(Long id) {
        Plato plato = findById(id);
        platoRepository.delete(plato);
    }
}
