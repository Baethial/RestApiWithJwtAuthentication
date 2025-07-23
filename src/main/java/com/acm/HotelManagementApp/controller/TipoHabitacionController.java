package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.TipoHabitacionDTO;
import com.acm.HotelManagementApp.model.TipoHabitacion;
import com.acm.HotelManagementApp.service.impl.TipoHabitacionServiceImpl;
import com.acm.HotelManagementApp.util.mapping.ITipoHabitacionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos_habitacion")
@RequiredArgsConstructor
@Slf4j
public class TipoHabitacionController {

    private final TipoHabitacionServiceImpl tipoHabitacionService;
    private final ITipoHabitacionMapper tipoHabitacionMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacionDTO> getTipoHabitacionById(@PathVariable Long id) {
        TipoHabitacion tipoHabitacion = tipoHabitacionService.findById(id);
        TipoHabitacionDTO tipoHabitacionDTO = tipoHabitacionMapper.modelToDto(tipoHabitacion);
        return ResponseEntity.ok(tipoHabitacionDTO);
    }

    @GetMapping
    public ResponseEntity<List<TipoHabitacionDTO>> getAllTipoHabitaciones() {
        List<TipoHabitacion> tipoHabitaciones = tipoHabitacionService.findAll();
        List<TipoHabitacionDTO> tiposHabitacionDTOs = tipoHabitaciones.stream().map(tipoHabitacionMapper::modelToDto).toList();
        return ResponseEntity.ok(tiposHabitacionDTOs);
    }

    @PostMapping
    public ResponseEntity<TipoHabitacionDTO> saveTipoHabitacion(@RequestBody TipoHabitacionDTO tipoHabitacionDTO) {
        TipoHabitacion tipoHabitacion = tipoHabitacionMapper.dtoToModel(tipoHabitacionDTO);
        TipoHabitacion savedTipoHabitacion = tipoHabitacionService.save(tipoHabitacion);
        TipoHabitacionDTO savedTipoHabitacionDTO = tipoHabitacionMapper.modelToDto(savedTipoHabitacion);
        return ResponseEntity.ok(savedTipoHabitacionDTO);
    }

    @PutMapping
    public ResponseEntity<TipoHabitacionDTO> updateTipoHabitacion(@RequestBody TipoHabitacionDTO tipoHabitacionDTO) {
        TipoHabitacion tipoHabitacion = tipoHabitacionMapper.dtoToModel(tipoHabitacionDTO);
        TipoHabitacion updatedTipoHabitacion = tipoHabitacionService.update(tipoHabitacion);
        TipoHabitacionDTO updatedTipoHabitacionDTO = tipoHabitacionMapper.modelToDto(updatedTipoHabitacion);
        return ResponseEntity.ok(updatedTipoHabitacionDTO);
    }

    @DeleteMapping
    public ResponseEntity<TipoHabitacionDTO> deleteTipoHabitacion(@PathVariable Long id) {
        tipoHabitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}