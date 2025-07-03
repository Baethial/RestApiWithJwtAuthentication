package com.acm.hotelgestion.controller;

import com.acm.hotelgestion.persistence.HabitacionEntity;
import com.acm.hotelgestion.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {

    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionEntity> getHabitacionById(@PathVariable Long id) {
        return ResponseEntity.ok(habitacionService.findHabitacionById(id));
    }

    @GetMapping
    public ResponseEntity<List<HabitacionEntity>> getAllHabitaciones() {
        return ResponseEntity.ok(habitacionService.findAllHabitaciones());
    }

    @PostMapping
    public ResponseEntity<HabitacionEntity> saveHabitacion(@RequestBody HabitacionEntity habitacionEntity) {
        return ResponseEntity.ok(habitacionService.saveHabitacion(habitacionEntity));
    }

    @PutMapping
    public ResponseEntity<HabitacionEntity> updateHabitacion(@RequestBody HabitacionEntity habitacionEntity) {
        return ResponseEntity.ok(habitacionService.updateHabitacion(habitacionEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HabitacionEntity> deleteHabitacion(@PathVariable Long id) {
        habitacionService.deleteHabitacionById(id);
        return ResponseEntity.noContent().build();
    }
}
