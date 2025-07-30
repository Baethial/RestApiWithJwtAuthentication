package com.acm.HotelManagementApp.controller.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionDTO {

    @NotBlank(message = "Room type name cannot be blank")
    @Size(min = 3, max = 50, message = "Room type name must be between 3 and 50 characters")
    private String nombre;

    @NotNull(message = "Capacity cannot be null")
    @Min(value = 1, message = "Capacity must be at least 1")
    @Max(value = 10, message = "Capacity cannot exceed 10")
    private Integer cantidad;

    // Optional?

    // private List<Long> idsHabitaciones;

}
