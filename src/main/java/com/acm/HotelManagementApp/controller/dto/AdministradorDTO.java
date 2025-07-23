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
public class AdministradorDTO {

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

    @Size(min = 2, max = 50, message = "First surname must be between 2 and 50 characters")
    private String segundoApellido;

    @NotBlank(message = "Email cannot be blank")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email must be valid")
    private String correo;

    @NotBlank(message = "Phone cannot be blank")
    @NotNull(message = "Phone cannot be null")
    @Pattern(regexp = "^[+]?[0-9]{7,15}$", message = "Phone number must be valid")
    private String telefono;
}
