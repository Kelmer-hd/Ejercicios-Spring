package com.kelmerdev.controller;

import com.kelmerdev.entity.Mesa;
import com.kelmerdev.services.MesaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@AllArgsConstructor
public class MesaController {
    private final MesaService mesaService;

    @GetMapping
    public List<Mesa> getAll() {
        return mesaService.getAllMesas();
    }

    @GetMapping("/{id}")
    public Mesa getMesaById(@PathVariable Long id) {
        return mesaService.getMesaById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mesa createMesa(@RequestBody @Validated Mesa mesa) {
        return mesaService.createMesa(mesa);
    }

    @PutMapping("/{id}")
    public Mesa updateMesa(@PathVariable Long id, @Validated @RequestBody Mesa mesa) {
        return mesaService.updateMesa(id, mesa);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
    }
}
