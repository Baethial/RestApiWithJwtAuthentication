package com.acm.HotelManagementApp.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "administrador_general")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdministradorGeneralEntity {

    @Id
    @Column(name = "id_administrador_general")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
}
