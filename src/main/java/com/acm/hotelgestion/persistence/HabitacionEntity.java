package com.acm.hotelgestion.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "habitacion")
public class HabitacionEntity implements Serializable {

    @Id
    @Column(name = "id_habitacion")
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

    public HabitacionEntity() {
    }

    public HabitacionEntity(Long id, Long numeroHabitacion, Long precioDia, Boolean disponible, HotelEntity hotel, TipoHabitacionEntity tipoHabitacion, List<ReservaEntity> reservas) {
        this.id = id;
        this.numeroHabitacion = numeroHabitacion;
        this.precioDia = precioDia;
        this.disponible = disponible;
        this.hotel = hotel;
        this.tipoHabitacion = tipoHabitacion;
        this.reservas = reservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Long numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Long getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(Long precioDia) {
        this.precioDia = precioDia;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public TipoHabitacionEntity getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacionEntity tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public List<ReservaEntity> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }
}