package com.acm.HotelManagementApp.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "rol")
    private String rol;

    @ManyToOne
    @JoinColumn(name = "fk_id_cliente")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "fk_id_empleado")
    private EmpleadoEntity empleado;

    @ManyToOne
    @JoinColumn(name = "fk_id_administrador")
    private AdministradorEntity administrador;

    @ManyToOne
    @JoinColumn(name = "fk_id_administrador_general")
    private AdministradorGeneralEntity administradorGeneral;
}
