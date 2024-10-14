package kelmer.dev.services;

import kelmer.dev.entiti.Libro;
import kelmer.dev.repositoty.LibroRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data

public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // OBTENER TODOS LOS LIBROS
    public List<Libro> getAllLibros(){
        return libroRepository.findAll();
    }

    // AÑADIR UN NUEVO LIBRO

    public Libro create(Libro libro){
        return libroRepository.save(libro);
    }

}
