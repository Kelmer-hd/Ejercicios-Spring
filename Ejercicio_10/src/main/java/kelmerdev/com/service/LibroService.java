package kelmerdev.com.service;

import kelmerdev.com.dto.LibroDTO;
import kelmerdev.com.exception.ResourceNotFoundException;
import kelmerdev.com.model.Biblioteca;
import kelmerdev.com.model.Libro;
import kelmerdev.com.repository.LibroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibroService {
    private LibroRepository libroRepository;
    private BibliotecaService bibliotecaService;
    // Crear un libro en una biblioteca especifica
    public Libro create(Long bibliotecaId, LibroDTO libroDTO) {

        // Buscar la biblioteca por su Id
        Biblioteca biblioteca = bibliotecaService.getById(bibliotecaId);
        Libro nuevoLibro = new Libro();

        nuevoLibro.setTitulo(libroDTO.getTitulo());
        nuevoLibro.setAutor(libroDTO.getAutor());
        nuevoLibro.setIsbn(libroDTO.getIsbn());
        nuevoLibro.setAnioPublicacion(libroDTO.getAnioPublicacion());
        nuevoLibro.setCantidadCopias(libroDTO.getCantidadCopias());
        nuevoLibro.setBiblioteca(biblioteca); // asociar el libro con la biblioteca

        return libroRepository.save(nuevoLibro);
    }

    // Obtener todos los libros
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    // Obtener un libro por su ID
    public Libro findById(Long id) {
        return libroRepository.findById(id).orElseThrow( ResourceNotFoundException:: new);
    }

    // Actualizar libro
    public Libro update(Long id, LibroDTO libroDTO) {
        Libro existeLibro = findById(id);
        existeLibro.setTitulo(libroDTO.getTitulo());
        existeLibro.setAutor(libroDTO.getAutor());
        existeLibro.setIsbn(libroDTO.getIsbn());
        existeLibro.setAnioPublicacion(libroDTO.getAnioPublicacion());
        existeLibro.setCantidadCopias(libroDTO.getCantidadCopias());
        return libroRepository.save(existeLibro);

    }

    // Eliminar Libro

    public void  delete(Long id){
        Libro existeLibro = findById(id);
        libroRepository.delete(existeLibro);
    }

    // Buscar libros por autor
    public Libro getLibroByAutor(String autor){
        return libroRepository.findByAutor(autor);
    }

    // Buscar Libros por titulo
    public Libro getLibroByTitulo(String titulo){
        return libroRepository.findByTitulo(titulo);
    }

}
