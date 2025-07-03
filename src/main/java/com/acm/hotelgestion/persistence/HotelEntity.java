package com.acm.hotelgestion.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
public class HotelEntity implements Serializable {

   @Id
   @Column(name = "id_hotel")
    private Long id;

   private String nombre;
   private String ciudad;
   private String telefono;
   private String correo;
   private String direccion;

   @OneToMany(mappedBy = "hotel")
   @JsonManagedReference("hotel-habitaciones")
   private List<HabitacionEntity> habitaciones = new ArrayList<>();

   public HotelEntity() {
   }

    public HotelEntity(Long id, String nombre, String ciudad, String telefono, String correo, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<HabitacionEntity> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<HabitacionEntity> habitaciones) {
        this.habitaciones = habitaciones;
    }
}