package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.EmpleadoEntity;
import com.acm.hotelgestion.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoEntity> getAdministradorById(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.findEmpleadoById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoEntity>> getAllAdministradores() {
        return ResponseEntity.ok(empleadoService.findAllEmpleados());
    }

    @PostMapping
    public ResponseEntity<EmpleadoEntity> saveAdministrador(@RequestBody EmpleadoEntity empleadoEntity) {
        return ResponseEntity.ok(empleadoService.saveEmpleado(empleadoEntity));
    }

    @PutMapping
    public ResponseEntity<EmpleadoEntity> updateAdministrador(@RequestBody EmpleadoEntity empleadoEntity) {
        return ResponseEntity.ok(empleadoService.updateEmpleado(empleadoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpleadoEntity> deleteAdministradorById(@PathVariable Long id) {
        empleadoService.deleteEmpleadoById(id);
        return ResponseEntity.noContent().build();
    }

}

