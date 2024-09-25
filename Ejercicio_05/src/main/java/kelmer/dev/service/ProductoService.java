package kelmer.dev.service;

import kelmer.dev.dto.ProductoFormDTO;
import kelmer.dev.exception.ResourceNotFoundException;
import kelmer.dev.model.Producto;
import kelmer.dev.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductoService {
    ProductoRepository productoRepository;

    public List<Producto> listar(){
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Long id){
        return productoRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Producto guardar(ProductoFormDTO productoFormDTO){
        Producto producto = new Producto();
        producto.setNombre(productoFormDTO.getNombre());
        producto.setPrecio(productoFormDTO.getPrecio());
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, ProductoFormDTO productoFormDTO){
        Producto productoActualizado = buscarPorId(id);
        productoActualizado.setNombre(productoFormDTO.getNombre());
        productoActualizado.setPrecio(productoFormDTO.getPrecio());
        return productoRepository.save(productoActualizado);
    }

    public void  eliminar(Long id){
        Producto producto = buscarPorId(id);
        productoRepository.delete(producto);
    }
}
