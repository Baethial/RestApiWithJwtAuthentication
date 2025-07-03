package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.AdministradorEntity;
import com.acm.hotelgestion.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    private final AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorEntity> getAdministradorById(@PathVariable Long id) {
        return ResponseEntity.ok(administradorService.findAdministradorById(id));
    }

    @GetMapping
    public ResponseEntity<List<AdministradorEntity>> getAllAdministradores() {
        return ResponseEntity.ok(administradorService.findAllAdministradores());
    }

    @PostMapping
    public ResponseEntity<AdministradorEntity> saveAdministrador(@RequestBody AdministradorEntity administradorEntity) {
        return ResponseEntity.ok(administradorService.saveAdministrador(administradorEntity));
    }

    @PutMapping
    public ResponseEntity<AdministradorEntity> updateAdministrador(@RequestBody AdministradorEntity administradorEntity) {
        return ResponseEntity.ok(administradorService.updateAdministrador(administradorEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdministradorEntity> deleteAdministradorById(@PathVariable Long id) {
        administradorService.deleteAdministradorById(id);
        return ResponseEntity.noContent().build();
    }

}

