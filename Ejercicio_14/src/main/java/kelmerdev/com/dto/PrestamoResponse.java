package kelmerdev.com.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PrestamoResponse {
    private Long id;
    private String titulo;
    private String nombreUsuario;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucionEsperada;
    private String status;
}