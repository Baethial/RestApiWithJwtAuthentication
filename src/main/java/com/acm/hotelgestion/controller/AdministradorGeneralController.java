package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.AdministradorGeneralEntity;
import com.acm.hotelgestion.service.AdministradorGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administradores_generales")
public class AdministradorGeneralController {

    private final AdministradorGeneralService administradorGeneralService;

    @Autowired
    public AdministradorGeneralController(AdministradorGeneralService administradorGeneralService) {
        this.administradorGeneralService = administradorGeneralService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorGeneralEntity> getAdministradorGeneralById(@PathVariable Long id) {
        return ResponseEntity.ok(administradorGeneralService.findAdministradorGeneralById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<AdministradorGeneralEntity>> getAllAdministradoresGenerales() {
        return ResponseEntity.ok(administradorGeneralService.findAllAdministradoresGenerales());
    }

    @PostMapping
    public ResponseEntity<AdministradorGeneralEntity> saveAdministradorGeneral(@RequestBody AdministradorGeneralEntity administradorGeneralEntity) {
        return ResponseEntity.ok(administradorGeneralService.saveAdministradorGeneral(administradorGeneralEntity));
    }

    @PutMapping
    public ResponseEntity<AdministradorGeneralEntity> updateAdministradorGeneral(@RequestBody AdministradorGeneralEntity administradorGeneralEntity) {
        return ResponseEntity.ok(administradorGeneralService.updateAdministradorGeneral(administradorGeneralEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministradorGeneralById(@PathVariable Long id) {
        administradorGeneralService.deleteAdministradorGeneralById(id);
        return ResponseEntity.noContent().build();
    }

}
