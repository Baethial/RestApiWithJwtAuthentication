package com.acm.HotelManagementApp.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    @NotBlank(message = "First name cannot be blank")
    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String primerNombre;

    @Size(min = 2, max = 50, message = "Second name must be between 2 and 50 characters")
    private String segundoNombre;

    @NotBlank(message = "First surname cannot be blank")
    @NotNull(message = "First surname cannot be null")
    @Size(min = 2, max = 50, message = "First surname must be between 2 and 50 characters")
    private String primerApellido;

    @Size(min = 2, max = 50, message = "Second surname must be between 2 and 50 characters")
    private String segundoApellido;

    @NotBlank(message = "ID document cannot be blank")
    @NotNull(message = "ID document cannot be null")
    @Pattern(regexp = "^[0-9]{8,12}$", message = "ID document must be between 8 and 12 digits")
    private String cedula;

    @NotBlank(message = "Address cannot be blank")
    @NotNull(message = "Address cannot be null")
    @Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters")
    private String direccion;

    // Optional?

    // private List<Long> idsReservas;
}
