package kelmerdev.com.model;


public enum StatusLibro {
    DISPONIBLE("Libro disponible para préstamo"),
    PRESTADO("Libro actualmente prestado"),
    EN_MANTENIMIENTO("Libro en mantenimiento o reparación");

    private final String descripcion;

    StatusLibro(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}