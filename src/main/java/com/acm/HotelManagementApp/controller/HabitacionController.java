package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.HabitacionDTO;
import com.acm.HotelManagementApp.model.Habitacion;
import com.acm.HotelManagementApp.service.impl.HabitacionServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IHabitacionMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@RequiredArgsConstructor
@Validated
public class HabitacionController {

    private final HabitacionServiceImpl habitacionService;
    private final IHabitacionMapper habitacionMapper;

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionDTO> getHabitacionById(@PathVariable Long id) {
        Habitacion habitacion = habitacionService.findById(id);
        HabitacionDTO habitacionDTO = habitacionMapper.modelToDto(habitacion);
        return ResponseEntity.ok(habitacionDTO);
    }

    @GetMapping
    public ResponseEntity<List<HabitacionDTO>> getAllHabitaciones() {
        List<Habitacion> habitaciones = habitacionService.findAll();
        List<HabitacionDTO> habitacionesDTOs = habitaciones.stream().map(habitacionMapper::modelToDto).toList();
        return ResponseEntity.ok(habitacionesDTOs);
    }

    @PostMapping
    public ResponseEntity<HabitacionDTO> saveHabitacion(@Valid @RequestBody HabitacionDTO habitacionDTO) {
        Habitacion habitacion = habitacionMapper.dtoToModel(habitacionDTO);
        Habitacion savedHabitacion = habitacionService.save(habitacion);
        HabitacionDTO savedHabitacionDTO = habitacionMapper.modelToDto(savedHabitacion);
        return ResponseEntity.ok(savedHabitacionDTO);
    }

    @PutMapping
    public ResponseEntity<HabitacionDTO> updateHabitacion(@Valid @RequestBody HabitacionDTO habitacionDTO) {
        Habitacion habitacion = habitacionMapper.dtoToModel(habitacionDTO);
        Habitacion updatedHabitacion = habitacionService.update(habitacion);
        HabitacionDTO updatedHabitacionDTO = habitacionMapper.modelToDto(updatedHabitacion);
        return ResponseEntity.ok(updatedHabitacionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HabitacionDTO> deleteHabitacion(@PathVariable Long id) {
        habitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
