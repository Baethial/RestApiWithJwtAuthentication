package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.TipoHabitacionEntity;
import com.acm.hotelgestion.service.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos_habitacion")
public class TipoHabitacionController {

    private final TipoHabitacionService tipoHabitacionService;

    @Autowired
    public TipoHabitacionController(TipoHabitacionService tipoHabitacionService) {
        this.tipoHabitacionService = tipoHabitacionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacionEntity> getTipoHabitacionById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoHabitacionService.findTipoHabitacionById(id));
    }

    @GetMapping
    public ResponseEntity<List<TipoHabitacionEntity>> getAllTipoHabitaciones() {
        return ResponseEntity.ok(tipoHabitacionService.findAllTipoHabitaciones());
    }

    @PostMapping
    public ResponseEntity<TipoHabitacionEntity> saveTipoHabitacion(@RequestBody TipoHabitacionEntity tipoHabitacionEntity) {
        return ResponseEntity.ok(tipoHabitacionService.saveTipoHabitacion(tipoHabitacionEntity));
    }

    @PutMapping
    public ResponseEntity<TipoHabitacionEntity> updateTipoHabitacion(@RequestBody TipoHabitacionEntity tipoHabitacionEntity) {
        return ResponseEntity.ok(tipoHabitacionService.updateTipoHabitacion(tipoHabitacionEntity));
    }

    @DeleteMapping
    public ResponseEntity<TipoHabitacionEntity> deleteTipoHabitacion(@PathVariable Long id) {
        tipoHabitacionService.deleteTipoHabitacionById(id);
        return ResponseEntity.noContent().build();
    }

}
