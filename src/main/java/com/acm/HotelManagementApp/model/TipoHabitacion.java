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
public class TipoHabitacion {

    private Long id;
    private String nombre;
    private Integer cantidad;
    private List<Habitacion> habitaciones;
}
