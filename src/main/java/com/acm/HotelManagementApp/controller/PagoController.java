package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.PagoDTO;
import com.acm.HotelManagementApp.model.Pago;
import com.acm.HotelManagementApp.service.impl.PagoServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IPagoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
@Slf4j
public class PagoController {

    private final PagoServiceImpl pagoService;
    private final IPagoMapper pagoMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> getPagoById(@PathVariable Long id) {
        Pago pago = pagoService.findById(id);
        PagoDTO pagoDTO = pagoMapper.modelToDto(pago);
        return ResponseEntity.ok(pagoDTO);
    }

    @GetMapping
    public ResponseEntity<List<PagoDTO>> getAllPagos() {
        List<Pago> pagos = pagoService.findAll();
        List<PagoDTO> pagosDTOs = pagos.stream().map(pagoMapper::modelToDto).toList();
        return ResponseEntity.ok(pagosDTOs);
    }

    @PostMapping
    public ResponseEntity<PagoDTO> savePago(@Valid @RequestBody PagoDTO pagoDTO) {
        Pago pago = pagoMapper.dtoToModel(pagoDTO);
        Pago savedPago = pagoService.save(pago);
        PagoDTO savedPagoDTO = pagoMapper.modelToDto(savedPago);
        return ResponseEntity.ok(savedPagoDTO);
    }

    @PutMapping
    public ResponseEntity<PagoDTO> updatePago(@Valid @RequestBody PagoDTO pagoDTO) {
        Pago pago = pagoMapper.dtoToModel(pagoDTO);
        Pago updatedPago = pagoService.update(pago);
        PagoDTO updatedPagoDTO = pagoMapper.modelToDto(updatedPago);
        return ResponseEntity.ok(updatedPagoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagoDTO> deletePagoById(@PathVariable Long id) {
        pagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
