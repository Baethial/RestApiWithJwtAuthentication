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
public class UsuarioDTO {

    @NotBlank(message = "Username cannot be blank")
    @NotNull(message = "Username cannot be null")
    @Size(min = 4, max = 50, message = "Username must be between 4 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contain letters, numbers, and underscores")
    private String nombreUsuario;

    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    private String contrasena;

    @NotBlank(message = "Role cannot be blank")
    @NotNull(message = "Role cannot be null")
    @Pattern(regexp = "^(CLIENTE|EMPLEADO|ADMINISTRADOR|ADMINISTRADOR_GENERAL)$",
            message = "Role must be: CLIENTE, EMPLEADO, ADMINISTRADOR, or ADMINISTRADOR_GENERAL")
    private String rol;

    // Optional?

    private Long idCliente;
    private Long idEmpleado;
    private Long idAdministrador;
    private Long idAdministradorGeneral;
}