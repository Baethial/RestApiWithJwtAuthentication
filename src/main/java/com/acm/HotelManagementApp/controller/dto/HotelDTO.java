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

public class HotelDTO {

    @NotBlank(message = "Hotel name cannot be blank")
    @NotNull(message = "Hotel name cannot be null")
    @Size(min = 3, max = 100, message = "Hotel name must be between 3 and 100 characters")
    private String nombre;

    @NotBlank(message = "City cannot be blank")
    @NotNull(message = "City cannot be null")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String ciudad;

    @NotBlank(message = "Phone number cannot be blank")
    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "^[+]?[0-9]{7,15}$", message = "Phone number must be valid")
    private String telefono;

    @NotBlank(message = "Email cannot be blank")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email must be valid")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String correo;

    @NotBlank(message = "Address cannot be blank")
    @NotNull(message = "Address cannot be null")
    @Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters")
    private String direccion;

    // Optional?

    // private List<Long> idsHabitaciones;
}
