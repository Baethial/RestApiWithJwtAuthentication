package com.acm.HotelManagementApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "habitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionEntity implements Serializable {

    @Id
    @Column(name = "id_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_habitacion")
    private Long numeroHabitacion;
    @Column(name = "precio_dia")
    private Long precioDia;
    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel", nullable = false)
    @JsonBackReference("hotel-habitaciones")
    private HotelEntity hotel;

    @ManyToOne
    @JoinColumn(name = "fk_id_tipo_habitacion", nullable = false)
    @JsonBackReference("tipo-habitaciones")
    private TipoHabitacionEntity tipoHabitacion;

    // Una habitacion puede tener varias reservas en el tiempo
    @OneToMany(mappedBy = "habitacion")
    @JsonManagedReference("habitacion-reservas")  // Changed from @JsonBackReference
    private List<ReservaEntity> reservas;
}