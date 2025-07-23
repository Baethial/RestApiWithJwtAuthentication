package com.acm.HotelManagementApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoEntity implements Serializable {

    @Id
    @Column(name = "id_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private LocalDateTime fecha;
    @Column(name = "metodo_pago")
    private String metodoPago;
    @Column(name = "pago_total")
    private BigDecimal pagoTotal;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva", nullable = false)
    @JsonBackReference("reserva-pagos")  // Added name
    private ReservaEntity reserva;

    @OneToOne(mappedBy = "pago")
    @JsonBackReference("factura-pago")  // Added name
    private FacturaEntity factura;
}