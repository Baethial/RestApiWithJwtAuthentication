package com.acm.hotelgestion.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "factura")
public class FacturaEntity implements Serializable {

    @Id
    @Column(name = "id_factura")
    private Long id;
    @Column(name = "fecha_emision")
    private String fechaEmision;
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

    public FacturaEntity() {
    }

    public FacturaEntity(Long id, String fechaEmision, Long valorTotal, PagoEntity pago, ReservaEntity reserva) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.valorTotal = valorTotal;
        this.pago = pago;
        this.reserva = reserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PagoEntity getPago() {
        return pago;
    }

    public void setPago(PagoEntity pago) {
        this.pago = pago;
    }

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }
}