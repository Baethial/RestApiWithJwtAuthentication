package com.acm.HotelManagementApp.controller.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionDTO {

    @NotBlank(message = "Room number cannot be blank")
    @NotNull(message = "Room number cannot be null")
    @Positive(message = "Room number must be positive")
    private Long numeroHabitacion;

    @NotBlank(message = "Daily price cannot be blank")
    @NotNull(message = "Daily price cannot be null")
    @DecimalMin(value = "0.01", message = "Daily price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Invalid price format")
    private BigDecimal precioDia;

    @NotBlank(message = "The availability cannot be blank")
    @NotNull(message = "The availability cannot be null")
    private Boolean disponible;

    @NotBlank(message = "Hotel ID cannot be blank")
    @NotNull(message = "Hotel ID cannot be null")
    @Positive(message = "Hotel ID must be positive")
    private Long idHotel;

    @NotBlank(message = "Room type ID cannot be blank")
    @NotNull(message = "Room type ID cannot be null")
    @Positive(message = "Room type ID must be positive")
    private Long idTipoHabitacion;

    // Optional

    // private List<Long> idsReservas;
}
