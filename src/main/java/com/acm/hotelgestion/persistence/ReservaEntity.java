package com.acm.hotelgestion.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reserva")
public class ReservaEntity implements Serializable {

    @Id
    @Column(name = "id_reserva")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_final")
    private Date fechaFin;
    @Column(name = "cantidad_dias")
    private Long cantidadDias;
    @Column(name = "estado")
    private Boolean estado;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_reserva")
    private Date fechaReserva;

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

    public ReservaEntity() {
    }

    public ReservaEntity(Long id, Date fechaInicio, Date fechaFin, Long cantidadDias, Boolean estado, Date fechaReserva, HabitacionEntity habitacion, ClienteEntity cliente, List<FacturaEntity> facturas, List<PagoEntity> pagos) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadDias = cantidadDias;
        this.estado = estado;
        this.fechaReserva = fechaReserva;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.facturas = facturas;
        this.pagos = pagos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(Long cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public HabitacionEntity getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(HabitacionEntity habitacion) {
        this.habitacion = habitacion;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public List<FacturaEntity> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaEntity> facturas) {
        this.facturas = facturas;
    }

    public List<PagoEntity> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }
}