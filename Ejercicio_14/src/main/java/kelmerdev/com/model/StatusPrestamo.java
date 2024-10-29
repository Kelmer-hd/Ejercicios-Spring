package kelmerdev.com.model;

public enum StatusPrestamo {
    ACTIVO("Préstamo en curso"),
    DEVUELTO("Libro devuelto"),
    VENCIDO("Préstamo vencido");

    private final String descripcion;

    StatusPrestamo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}