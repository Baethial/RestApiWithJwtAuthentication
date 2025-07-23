package com.acm.HotelManagementApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaEntity implements Serializable {

    @Id
    @Column(name = "id_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_emision")
    private String fechaEmision; // This was a String
    @Column(name = "valor_total")
    private Long valorTotal;

    @OneToOne
    @JoinColumn(name = "fk_id_pago")
    @JsonManagedReference("factura-pago")  // Added name
    private PagoEntity pago;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    @JsonBackReference("reserva-facturas")  // Added name
    private ReservaEntity reserva;
}