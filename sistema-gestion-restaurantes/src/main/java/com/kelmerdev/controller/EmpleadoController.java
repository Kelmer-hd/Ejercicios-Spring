package com.kelmerdev.controller;

import com.kelmerdev.model.dto.EmpleadoDTO;
import com.kelmerdev.model.entity.Empleado;
import com.kelmerdev.service.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@AllArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> findAllEmpleado() {
        return empleadoService.findAll();
    }

    @GetMapping("/{id}")
    public Empleado findById(@PathVariable Long id) {
        return empleadoService.findById(id);

    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Empleado save(@RequestBody @Validated EmpleadoDTO empleadoDTO) {
        return empleadoService.save(empleadoDTO);
    }

    @PutMapping("/{id}")
    public Empleado update(@PathVariable Long id, @RequestBody @Validated EmpleadoDTO empleadoDTO) {
        return empleadoService.update(id, empleadoDTO);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        empleadoService.delete(id);
    }
}
