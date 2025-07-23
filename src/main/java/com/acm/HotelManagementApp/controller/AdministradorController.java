package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.AdministradorDTO;
import com.acm.HotelManagementApp.model.Administrador;
import com.acm.HotelManagementApp.service.impl.AdministradorServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IAdministradorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
@RequiredArgsConstructor
@Slf4j
public class AdministradorController {

    private final AdministradorServiceImpl administradorService;
    private final IAdministradorMapper administradorMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDTO> getAdministradorById(@PathVariable Long id) {
        Administrador administrador = administradorService.findById(id);
        AdministradorDTO administradorDTO = administradorMapper.modelToDto(administrador);
        return ResponseEntity.ok(administradorDTO);
    }

    @GetMapping
    public ResponseEntity<List<AdministradorDTO>> getAllAdministradores() {
        List<Administrador> administradores = administradorService.findAll();
        List<AdministradorDTO> administradoresDTOs = administradores.stream().map(administradorMapper::modelToDto).toList();
        return ResponseEntity.ok(administradoresDTOs);
    }

    @PostMapping
    public ResponseEntity<AdministradorDTO> saveAdministrador(@Valid @RequestBody AdministradorDTO administradorDTO) {
        Administrador administrador = administradorMapper.dtoToModel(administradorDTO);
        Administrador savedAdministrador = administradorService.save(administrador);
        AdministradorDTO savedAdministradorDTO = administradorMapper.modelToDto(savedAdministrador);
        return ResponseEntity.ok(savedAdministradorDTO);
    }

    @PutMapping
    public ResponseEntity<AdministradorDTO> updateAdministrador(@Valid @RequestBody AdministradorDTO administradorDTO) {
        Administrador administrador = administradorMapper.dtoToModel(administradorDTO);
        Administrador updatedAdministrador = administradorService.save(administrador);
        AdministradorDTO updatedAdministradorDTO = administradorMapper.modelToDto(updatedAdministrador);
        return ResponseEntity.ok(updatedAdministradorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdministradorDTO> deleteAdministradorById(@PathVariable Long id) {
        administradorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}