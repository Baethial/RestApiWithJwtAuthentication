package com.acm.HotelManagementApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reserva")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaEntity implements Serializable {

    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_final")
    private LocalDateTime fechaFin;
    @Column(name = "cantidad_dias")
    private Long cantidadDias;
    @Column(name = "estado")
    private Boolean estado;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @ManyToOne
    @JoinColumn(name = "fk_id_habitacion", nullable = false)
    @JsonBackReference("habitacion-reservas")  // Changed from @JsonManagedReference
    private HabitacionEntity habitacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_cliente", nullable = false)
    @JsonBackReference("cliente-reservas")  // Changed from @JsonManagedReference and added name
    private ClienteEntity cliente;

    // Una reserva puede tener varias facturas
    @OneToMany(mappedBy = "reserva")
    @JsonManagedReference("reserva-facturas")  // Added name
    private List<FacturaEntity> facturas;

    @OneToMany(mappedBy = "reserva")
    @JsonManagedReference("reserva-pagos")  // Added name
    private List<PagoEntity> pagos;
}