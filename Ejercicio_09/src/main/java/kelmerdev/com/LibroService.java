package kelmerdev.com;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibroService {
    private LIbroRepository lIbroRepository;

    public List<Libro> getLibros() {
        return lIbroRepository.findAll();
    }

    public Libro create(Libro libro){
        return lIbroRepository.save(libro);
    }
}
