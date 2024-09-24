package kelmer.dev.ejercicio_02.model;

import lombok.Data;

@Data
public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

}
