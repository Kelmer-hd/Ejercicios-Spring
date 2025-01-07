package com.kelmerdev.service;

import com.kelmerdev.dto.EstudianteDTO;
import com.kelmerdev.exeception.BadRequestException;
import com.kelmerdev.exeception.ResourceNotFoundException;
import com.kelmerdev.model.Estudiante;
import com.kelmerdev.repository.EstudianteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Data
public class EstudianteService {

    private EstudianteRepository estudianteRepository;

    public List<Estudiante> getEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Estudiante getEstudiante(Long id){
        return estudianteRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Estudiante save(EstudianteDTO estudianteDTO){
        boolean emailAlreadyExists = estudianteRepository.existsByEmail(estudianteDTO.getEmail());

        if (emailAlreadyExists) {
            throw  new BadRequestException("El email ya existe");
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteDTO.getNombre());
        estudiante.setEmail(estudianteDTO.getEmail());
        estudiante.setTelefono(estudianteDTO.getTelefono());
        estudiante.setCreateAt(LocalDateTime.now());
        return estudianteRepository.save(estudiante);
    }

    public Estudiante update(Long id, EstudianteDTO estudianteDTO){
        boolean emailAlreadyExists = estudianteRepository.existsByEmail(estudianteDTO.getEmail());

        if (emailAlreadyExists) {
            throw  new BadRequestException("El email ya existe");
        }
        Estudiante estudiante = getEstudiante(id);
        estudiante.setNombre(estudianteDTO.getNombre());
        estudiante.setEmail(estudianteDTO.getEmail());
        estudiante.setTelefono(estudianteDTO.getTelefono());
        return estudianteRepository.save(estudiante);
    }

    public void delete(Long id){
        Estudiante estudiante = getEstudiante(id);
        estudianteRepository.delete(estudiante);
    }
}
