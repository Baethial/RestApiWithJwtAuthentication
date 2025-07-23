package com.acm.HotelManagementApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipo_habitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionEntity implements Serializable {

    @Id
    @Column(name = "id_tipo_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer cantidad;

    @OneToMany(mappedBy = "tipoHabitacion")
    @JsonManagedReference("tipo-habitaciones")  // Changed from @JsonBackReference
    private List<HabitacionEntity> habitaciones;
}