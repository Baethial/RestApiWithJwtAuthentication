package com.acm.hotelgestion.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pago")
public class PagoEntity implements Serializable {

    @Id
    @Column(name = "id_pago")
    private Long id;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "metodo_pago")
    private String metodoPago;
    @Column(name = "pago_total")
    private Integer pagoTotal;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva", nullable = false)
    @JsonBackReference("reserva-pagos")  // Added name
    private ReservaEntity reserva;

    @OneToOne(mappedBy = "pago")
    @JsonBackReference("factura-pago")  // Added name
    private FacturaEntity factura;

    public PagoEntity() {
    }

    public PagoEntity(Long id, Date fecha, String metodoPago, Integer pagoTotal, ReservaEntity reserva, FacturaEntity factura) {
        this.id = id;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.pagoTotal = pagoTotal;
        this.reserva = reserva;
        this.factura = factura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Integer getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(Integer pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }
}