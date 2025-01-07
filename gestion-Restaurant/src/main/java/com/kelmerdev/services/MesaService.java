package com.kelmerdev.services;

import com.kelmerdev.entity.Mesa;
import com.kelmerdev.exception.ResourceNotFoundException;
import com.kelmerdev.repository.MesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MesaService {
    private final MesaRepository mesaRepository;

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Mesa getMesaById(Long id) {
        return mesaRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Mesa createMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa updateMesa(Long id, Mesa mesa) {
        Mesa existedMesa = getMesaById(id);
        existedMesa.setNumeroMesa(mesa.getNumeroMesa());
        existedMesa.setCapacidad(mesa.getCapacidad());
        existedMesa.setEstado(mesa.getEstado());

        return mesaRepository.save(existedMesa);
    }

    public void deleteMesa(Long id) {
        Mesa existedMesa = getMesaById(id);
        mesaRepository.delete(existedMesa);
    }
}
