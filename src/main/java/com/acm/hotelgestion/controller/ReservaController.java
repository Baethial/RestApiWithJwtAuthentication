package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.ReservaEntity;
import com.acm.hotelgestion.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaEntity> getReservaById(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.findReservaById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReservaEntity>> getAllReservas() {
        return ResponseEntity.ok(reservaService.findAllReservas());
    }

    @PostMapping
    public ResponseEntity<ReservaEntity> saveReserva(@RequestBody ReservaEntity reservaEntity) {
        return ResponseEntity.ok(reservaService.saveReserva(reservaEntity));
    }

    @PutMapping
    public ResponseEntity<ReservaEntity> updateReserva(@RequestBody ReservaEntity reservaEntity) {
        return ResponseEntity.ok(reservaService.updateReserva(reservaEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservaEntity> deleteReservaById(@PathVariable Long id) {
        reservaService.deleteReservaById(id);
        return ResponseEntity.noContent().build();
    }

}
