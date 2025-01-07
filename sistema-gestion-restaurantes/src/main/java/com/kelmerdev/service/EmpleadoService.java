package com.kelmerdev.service;

import com.kelmerdev.exception.ResourceNotFoundException;
import com.kelmerdev.model.dto.EmpleadoDTO;
import com.kelmerdev.model.entity.Empleado;
import com.kelmerdev.repository.EmpleadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Empleado findById(Long id) {
        return empleadoRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Empleado save(EmpleadoDTO empleadoDTO) {
        Empleado empleadoSaved = new Empleado();
        empleadoSaved.setNombre(empleadoDTO.getNombre());
        empleadoSaved.setRol(empleadoDTO.getRol());
        empleadoSaved.setTurno(empleadoDTO.getTurno());
        return empleadoRepository.save(empleadoSaved);
    }

    public Empleado update(Long id, EmpleadoDTO empleadoDTO) {
        Empleado empleado = findById(id);
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setRol(empleadoDTO.getRol());
        empleado.setTurno(empleadoDTO.getTurno());
        return empleadoRepository.save(empleado);
    }

    public void delete(Long id) {
        Empleado empleado = findById(id);
        empleadoRepository.deleteById(empleado.getId());
    }

}
