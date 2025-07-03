package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.PagoEntity;
import com.acm.hotelgestion.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoEntity> getPagoById(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.findPagoById(id));
    }

    @GetMapping
    public ResponseEntity<List<PagoEntity>> getAllPagos() {
        return ResponseEntity.ok(pagoService.findAllPagos());
    }

    @PostMapping
    public ResponseEntity<PagoEntity> savePago(@RequestBody PagoEntity pagoEntity) {
        return ResponseEntity.ok(pagoService.savePago(pagoEntity));
    }

    @PutMapping
    public ResponseEntity<PagoEntity> updatePago(@RequestBody PagoEntity pagoEntity) {
        return ResponseEntity.ok(pagoService.updatePago(pagoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagoEntity> deletePagoById(@PathVariable Long id) {
        pagoService.deletePagoById(id);
        return ResponseEntity.noContent().build();
    }

}
