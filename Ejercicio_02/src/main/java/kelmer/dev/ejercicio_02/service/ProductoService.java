package kelmer.dev.ejercicio_02.service;

import kelmer.dev.ejercicio_02.model.Producto;
import kelmer.dev.ejercicio_02.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements ProductoRepository {
    @Override
    public Producto create(Producto producto) {
        return null;
    }
}
