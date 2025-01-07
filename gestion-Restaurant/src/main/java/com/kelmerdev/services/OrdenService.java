package com.kelmerdev.services;

import com.kelmerdev.entity.Orden;
import com.kelmerdev.exception.ResourceNotFoundException;
import com.kelmerdev.repository.OrdenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdenService {

    private final OrdenRepository ordenRepository;

    public List<Orden> getAll() {
        return ordenRepository.findAll();
    }

    public Orden getById(Long id) {
        return ordenRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    public Orden update(Long id, Orden orden) {
        return ordenRepository.findById(id)
                .map(ordenToUpdate -> {
                    ordenToUpdate.setFecha(LocalDateTime.now());
                    ordenToUpdate.setTotal(orden.getTotal());
                    ordenToUpdate.setMesa(orden.getMesa());
                    ordenToUpdate.setEstado(orden.getEstado());
                    ordenToUpdate.setMetodoPago(orden.getMetodoPago());
                    ordenToUpdate.setNotasEspeciales(orden.getNotasEspeciales());
                    ordenToUpdate.setPlatos(orden.getPlatos());
                    return ordenRepository.save(ordenToUpdate);
                })
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con id: " + id));
    }

    public void delete(Long id) {
        Orden ordenToDelete = getById(id);
        ordenRepository.delete(ordenToDelete);
    }
}
