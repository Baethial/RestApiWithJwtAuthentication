package com.acm.HotelManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    private Long id;
    private String nombreUsuario;
    private String contrasena;
    private String rol;

    private Cliente cliente;
    private Empleado empleado;
    private Administrador administrador;
    private AdministradorGeneral administradorGeneral;
}
