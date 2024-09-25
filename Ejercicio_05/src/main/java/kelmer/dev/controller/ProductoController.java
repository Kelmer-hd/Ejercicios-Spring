package kelmer.dev.controller;

import kelmer.dev.service.ProductoService;
import kelmer.dev.dto.ProductoFormDTO;
import kelmer.dev.model.Producto;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public Producto buscarProductoPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody @Validated ProductoFormDTO productoFormDTO) {
        return productoService.guardar(productoFormDTO);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @Validated @RequestBody ProductoFormDTO productoFormDTO) {
        return productoService.actualizar(id, productoFormDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
    }

}
