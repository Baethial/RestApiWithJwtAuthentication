package com.acm.hotelgestion.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipo_habitacion")
public class TipoHabitacionEntity implements Serializable {

    @Id
    @Column(name = "id_tipo_habitacion")
    private Long id;
    private String nombre;
    private Integer cantidad;

    @OneToMany(mappedBy = "tipoHabitacion")
    @JsonManagedReference("tipo-habitaciones")  // Changed from @JsonBackReference
    private List<HabitacionEntity> habitaciones;

    public TipoHabitacionEntity() {
    }

    public TipoHabitacionEntity(Long id, String nombre, Integer cantidad, List<HabitacionEntity> habitaciones) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.habitaciones = habitaciones;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<HabitacionEntity> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<HabitacionEntity> habitaciones) {
        this.habitaciones = habitaciones;
    }
}