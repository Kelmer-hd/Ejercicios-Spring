package kelmerdev.com.controller;

import jakarta.validation.Valid;
import kelmerdev.com.dto.PrestamoRequest;
import kelmerdev.com.dto.PrestamoResponse;
import kelmerdev.com.service.impl.PrestamoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@AllArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<PrestamoResponse> crearPrestamo(@Valid @RequestBody PrestamoRequest request) {
        PrestamoResponse response = prestamoService.createPrestamo(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<PrestamoResponse> devolverLibro(@PathVariable Long id) {
        PrestamoResponse response = prestamoService.devolverLibro(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PrestamoResponse>> obtenerPrestamosPorUsuario(@PathVariable Long userId) {
        List<PrestamoResponse> prestamos = prestamoService.obtenerPrestamosPorUsuario(userId);
        return ResponseEntity.ok(prestamos);
    }
}