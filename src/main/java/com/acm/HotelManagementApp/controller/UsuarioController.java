package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.UsuarioDTO;
import com.acm.HotelManagementApp.model.Usuario;
import com.acm.HotelManagementApp.service.impl.UsuarioServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IUsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@Slf4j
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;
    private final IUsuarioMapper usuarioMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        UsuarioDTO usuarioDTO = usuarioMapper.modelToDto(usuario);
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDTO> usuariosDTOs = usuarios.stream().map(usuarioMapper::modelToDto).toList();
        return ResponseEntity.ok(usuariosDTOs);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> saveUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        log.info("UsuarioDTO: {}", usuarioDTO);
        Usuario usuario = usuarioMapper.dtoToModel(usuarioDTO);
        log.info("Usuario: {}", usuario);
        Usuario savedUsuario = usuarioService.save(usuario);
        UsuarioDTO savedUsuarioDTO = usuarioMapper.modelToDto(savedUsuario);
        return ResponseEntity.ok(savedUsuarioDTO);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> updateUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.dtoToModel(usuarioDTO);
        Usuario updatedUsuario = usuarioService.save(usuario);
        UsuarioDTO updatedUsuarioDTO = usuarioMapper.modelToDto(updatedUsuario);
        return ResponseEntity.ok(updatedUsuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> deleteUsuarioById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
