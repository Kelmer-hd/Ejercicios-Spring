package kelmer.dev.ejercicio_04.controller;

import kelmer.dev.ejercicio_04.model.Producto;
import kelmer.dev.ejercicio_04.reposirory.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto save(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable Integer id){
        return productoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Integer id, @RequestBody Producto producto){
        Producto productoToUpdate = productoRepository.findById(id).orElse(null);
        if(productoToUpdate != null){
            productoToUpdate.setNombre(producto.getNombre());
            productoToUpdate.setPrecio(producto.getPrecio());
            return productoRepository.save(productoToUpdate);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productoRepository.deleteById(id);
    }
}
