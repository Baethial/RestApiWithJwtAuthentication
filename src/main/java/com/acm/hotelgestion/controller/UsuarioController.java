package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.UsuarioEntity;
import com.acm.hotelgestion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findUsuarioById(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAllUsuarios());
    }

    @PostMapping
    public ResponseEntity<UsuarioEntity> saveUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        return ResponseEntity.ok(usuarioService.saveUsuario(usuarioEntity));
    }

    @PutMapping
    public ResponseEntity<UsuarioEntity> updateUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        return ResponseEntity.ok(usuarioService.updateUsuario(usuarioEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioEntity> deleteUsuarioById(@PathVariable Long id) {
        usuarioService.deleteUsuarioById(id);
        return ResponseEntity.noContent().build();
    }

}
