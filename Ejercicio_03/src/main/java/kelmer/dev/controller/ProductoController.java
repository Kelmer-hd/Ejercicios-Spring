package kelmer.dev.controller;

import kelmer.dev.model.Producto;
import kelmer.dev.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> list(){
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto save(@RequestBody  Producto producto){
        return productoRepository.save(producto);
    }


}
