package kelmerdev.com.service;

import kelmerdev.com.exception.ResourceNotFoundException;
import kelmerdev.com.model.Biblioteca;
import kelmerdev.com.repository.BibliotecaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BibliotecaService {

    private BibliotecaRepository bibliotecaRepository;

    // Crear una Biblioteca
    public Biblioteca create(Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }

    // Obtener todas las bibliotecas
    public List<Biblioteca> getAll(){
        return bibliotecaRepository.findAll();
    }

    // Obtener una biblioteca por su id
    public Biblioteca getById(Long id){
        return bibliotecaRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    // Actualizar una biblioteca por su id
    public Biblioteca update(Long id, Biblioteca biblioteca){
        Biblioteca existedBiblioteca1 = getById(id);
        if (existedBiblioteca1 != null){
            existedBiblioteca1.setNombre(biblioteca.getNombre());
            existedBiblioteca1.setDireccion(biblioteca.getDireccion());
            existedBiblioteca1.setTelefono(biblioteca.getTelefono());
            return bibliotecaRepository.save(existedBiblioteca1);
        }

        return null;
    }

    // Eliminar una biblioteca por su id
    public void delete(Long id){
        Biblioteca existedBiblioteca1 = getById(id);
        if (existedBiblioteca1 != null){
            bibliotecaRepository.delete(existedBiblioteca1);
        }
    }
}
