package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.AdministradorGeneralDTO;
import com.acm.HotelManagementApp.model.AdministradorGeneral;
import com.acm.HotelManagementApp.service.impl.AdministradorGeneralServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IAdministradorGeneralMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores_generales")
@RequiredArgsConstructor
@Slf4j
public class AdministradorGeneralController {

    private final AdministradorGeneralServiceImpl administradorGeneralService;
    private final IAdministradorGeneralMapper administradorGeneralMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorGeneralDTO> getAdministradorGeneralById(@PathVariable Long id) {
        AdministradorGeneral administradorGeneral = administradorGeneralService.findById(id);
        AdministradorGeneralDTO administradorGeneralDTO = administradorGeneralMapper.modelToDto(administradorGeneral);
        return ResponseEntity.ok(administradorGeneralDTO);
    }

    @GetMapping
    public ResponseEntity<List<AdministradorGeneralDTO>> getAllAdministradoresGenerales() {
        List<AdministradorGeneral> administradoresGenerales = administradorGeneralService.findAll();
        List<AdministradorGeneralDTO> administradoresGeneralesDTOs = administradoresGenerales.stream().map(administradorGeneralMapper::modelToDto).toList();
        return ResponseEntity.ok(administradoresGeneralesDTOs);
    }

    @PostMapping
    public ResponseEntity<AdministradorGeneralDTO> saveAdministradorGeneral(@Valid @RequestBody AdministradorGeneralDTO administradorGeneralDTO) {
        AdministradorGeneral administradorGeneral = administradorGeneralMapper.dtoToModel(administradorGeneralDTO);
        AdministradorGeneral savedAdministradorGeneral = administradorGeneralService.save(administradorGeneral);
        AdministradorGeneralDTO savedAdministradorGeneralDTO = administradorGeneralMapper.modelToDto(savedAdministradorGeneral);
        return ResponseEntity.ok(savedAdministradorGeneralDTO);
    }

    @PutMapping
    public ResponseEntity<AdministradorGeneralDTO> updateAdministradorGeneral(@Valid @RequestBody AdministradorGeneralDTO administradorGeneralDTO) {
        AdministradorGeneral administradorGeneral = administradorGeneralMapper.dtoToModel(administradorGeneralDTO);
        AdministradorGeneral updatedAdministradorGeneral = administradorGeneralService.save(administradorGeneral);
        AdministradorGeneralDTO updatedAdministradorGeneralDTO = administradorGeneralMapper.modelToDto(updatedAdministradorGeneral);
        return ResponseEntity.ok(updatedAdministradorGeneralDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdministradorGeneralDTO> deleteAdministradorGeneralById(@PathVariable Long id) {
        administradorGeneralService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}