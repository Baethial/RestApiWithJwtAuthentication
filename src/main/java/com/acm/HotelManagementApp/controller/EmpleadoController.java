package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.EmpleadoDTO;
import com.acm.HotelManagementApp.model.Empleado;
import com.acm.HotelManagementApp.service.impl.EmpleadoServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IEmpleadoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
@Slf4j
public class EmpleadoController {

    private final EmpleadoServiceImpl empleadoService;
    private final IEmpleadoMapper empleadoMapper;

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> getEmpleadoById(@PathVariable Long id) {
        Empleado empleado = empleadoService.findById(id);
        EmpleadoDTO empleadoDTO = empleadoMapper.modelToDto(empleado);
        return ResponseEntity.ok(empleadoDTO);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.findAll();
        List<EmpleadoDTO> empleadosDTOs = empleados.stream().map(empleadoMapper::modelToDto).toList();
        return ResponseEntity.ok(empleadosDTOs);
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> saveEmpleado(@Valid @RequestBody EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoMapper.dtoToModel(empleadoDTO);
        Empleado savedEmpleado = empleadoService.save(empleado);
        EmpleadoDTO savedEmpleadoDTO = empleadoMapper.modelToDto(savedEmpleado);
        return ResponseEntity.ok(savedEmpleadoDTO);
    }

    @PutMapping
    public ResponseEntity<EmpleadoDTO> updateEmpleado(@Valid @RequestBody EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoMapper.dtoToModel(empleadoDTO);
        Empleado updatedEmpleado = empleadoService.save(empleado);
        EmpleadoDTO updatedEmpleadoDTO = empleadoMapper.modelToDto(updatedEmpleado);
        return ResponseEntity.ok(updatedEmpleadoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> deleteEmpleadoById(@PathVariable Long id) {
        empleadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

