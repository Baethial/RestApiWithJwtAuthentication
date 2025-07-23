package com.acm.HotelManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habitacion {

    private Long id;
    private Long numeroHabitacion;
    private Long precioDia;
    private Boolean disponible;
    private Hotel hotel;
    private TipoHabitacion tipoHabitacion;
    private List<Reserva> reservas;
}
