package com.acm.hotelgestion.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @Column(name = "id_usuario")
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

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nombreUsuario, String contrasena, String rol, ClienteEntity cliente, EmpleadoEntity empleado, AdministradorEntity administrador, AdministradorGeneralEntity administradorGeneral) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.cliente = cliente;
        this.empleado = empleado;
        this.administrador = administrador;
        this.administradorGeneral = administradorGeneral;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    public AdministradorEntity getAdministrador() {
        return administrador;
    }

    public void setAdministrador(AdministradorEntity administrador) {
        this.administrador = administrador;
    }

    public AdministradorGeneralEntity getAdministradorGeneral() {
        return administradorGeneral;
    }

    public void setAdministradorGeneral(AdministradorGeneralEntity administradorGeneral) {
        this.administradorGeneral = administradorGeneral;
    }
}
