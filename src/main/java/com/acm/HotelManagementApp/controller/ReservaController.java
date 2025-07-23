package com.acm.HotelManagementApp.controller;

import com.acm.HotelManagementApp.controller.dto.ReservaDTO;
import com.acm.HotelManagementApp.model.Reserva;
import com.acm.HotelManagementApp.service.impl.ReservaServiceImpl;
import com.acm.HotelManagementApp.util.mapping.IReservaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
@Slf4j
public class ReservaController {

    private final ReservaServiceImpl reservaService;
    private final IReservaMapper reservaMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getReservaById(@PathVariable Long id) {
        Reserva reserva = reservaService.findById(id);
        ReservaDTO reservaDTO = reservaMapper.modelToDto(reserva);
        return ResponseEntity.ok(reservaDTO);
    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> getAllReservas() {
        List<Reserva> reservas = reservaService.findAll();
        List<ReservaDTO> reservasDtos = reservas.stream().map(reservaMapper::modelToDto).toList();
        return ResponseEntity.ok(reservasDtos);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> saveReserva(@Valid @RequestBody ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.dtoToModel(reservaDTO);
        Reserva savedReserva = reservaService.save(reserva);
        ReservaDTO savedReservaDTO = reservaMapper.modelToDto(savedReserva);
        return ResponseEntity.ok(savedReservaDTO);
    }

    @PutMapping
    public ResponseEntity<ReservaDTO> updateReserva(@Valid @RequestBody ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.dtoToModel(reservaDTO);
        Reserva updatedReserva = reservaService.update(reserva);
        ReservaDTO updatedReservaDTO = reservaMapper.modelToDto(updatedReserva);
        return ResponseEntity.ok(updatedReservaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservaDTO> deleteReservaById(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
