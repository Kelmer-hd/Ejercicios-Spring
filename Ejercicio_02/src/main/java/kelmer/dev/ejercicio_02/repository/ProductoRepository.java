package kelmer.dev.ejercicio_02.repository;

import kelmer.dev.ejercicio_02.model.Producto;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository{
     Producto create(Producto producto);
}
