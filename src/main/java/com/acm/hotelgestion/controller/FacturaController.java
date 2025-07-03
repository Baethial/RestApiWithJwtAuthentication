package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.FacturaEntity;
import com.acm.hotelgestion.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaEntity> getFacturaById(@PathVariable Long id) {
        return ResponseEntity.ok(facturaService.findFacturaById(id));
    }

    @GetMapping
    public ResponseEntity<List<FacturaEntity>> getAllFacturas() {
        return ResponseEntity.ok(facturaService.findAllFacturas());
    }

    @PostMapping
    public ResponseEntity<FacturaEntity> saveFactura(@RequestBody FacturaEntity facturaEntity) {
        return ResponseEntity.ok(facturaService.saveFactura(facturaEntity));
    }

    @PutMapping
    public ResponseEntity<FacturaEntity> updateFactura(@RequestBody FacturaEntity facturaEntity) {
        return ResponseEntity.ok(facturaService.updateFactura(facturaEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FacturaEntity> deleteFacturaById(@PathVariable Long id) {
        facturaService.deleteFacturaById(id);
        return ResponseEntity.noContent().build();
    }

}
