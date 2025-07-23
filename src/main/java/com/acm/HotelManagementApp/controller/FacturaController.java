package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.FacturaDTO;
import com.acm.HotelManagementApp.model.Factura;
import com.acm.HotelManagementApp.service.impl.FacturaServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IFacturaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@RequiredArgsConstructor
@Slf4j
public class FacturaController {

    private final FacturaServiceImpl facturaService;
    private final IFacturaMapper facturaMapper;

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> getFacturaById(@PathVariable Long id) {
        Factura factura = facturaService.findById(id);
        FacturaDTO facturaDTO = facturaMapper.modelToDto(factura);
        return ResponseEntity.ok(facturaDTO);
    }

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> getAllFacturas() {
        List<Factura> facturas = facturaService.findAll();
        List<FacturaDTO> facturasDTOs = facturas.stream().map(facturaMapper::modelToDto).toList();
        return ResponseEntity.ok(facturasDTOs);
    }

    @PostMapping
    public ResponseEntity<FacturaDTO> saveFactura(@Valid @RequestBody FacturaDTO facturaDTO) {
        Factura factura = facturaMapper.dtoToModel(facturaDTO);
        Factura savedFactura = facturaService.save(factura);
        FacturaDTO savedFacturaDTO = facturaMapper.modelToDto(savedFactura);
        return ResponseEntity.ok(savedFacturaDTO);
    }

    @PutMapping
    public ResponseEntity<FacturaDTO> updateFactura(@Valid @RequestBody FacturaDTO facturaDTO) {
        Factura factura = facturaMapper.dtoToModel(facturaDTO);
        Factura updatedFactura = facturaService.update(factura);
        FacturaDTO updatedFacturaDTO = facturaMapper.modelToDto(updatedFactura);
        return ResponseEntity.ok(updatedFacturaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FacturaDTO> deleteFacturaById(@PathVariable Long id) {
        facturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
