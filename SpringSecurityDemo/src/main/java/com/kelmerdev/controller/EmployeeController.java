package com.kelmerdev.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String getAllEmployees(){
        return "You Received All Employees List";
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveEmployee(){
        return "You saved a Employee";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public String updateEmployee(){
        return "You updated a Employee";
    }
}
