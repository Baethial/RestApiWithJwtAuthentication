package com.acm.HotelManagementApp.controller.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaDTO {

    @NotBlank(message = "Reservation number cannot be blank")
    @NotNull(message = "Check-in date cannot be null")
    @Future(message = "Check-in date must be in the future")
    private LocalDateTime fechaInicio;

    @NotBlank(message = "Reservation number cannot be blank")
    @NotNull(message = "Check-out date cannot be null")
    @Future(message = "Check-out date must be in the future")
    private LocalDateTime fechaFin;

    @NotBlank(message = "Client name cannot be blank")
    @NotNull(message = "Client ID cannot be null")
    @Positive(message = "Client ID must be positive")
    private Long idCliente;

    @NotBlank(message = "Room type name cannot be blank")
    @NotNull(message = "Room ID cannot be null")
    @Positive(message = "Room ID must be positive")
    private Long idHabitacion;

    // Optional?

    private Long cantidadDias;
    private Boolean estado;
    private LocalDateTime fechaReserva;
    // private List<Long> idsFacturas;
    // private List<Long> idsPagos;
}
