package com.acm.HotelManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Long cantidadDias;
    private Boolean estado;
    private LocalDateTime fechaReserva;
    private Habitacion habitacion;
    private Cliente cliente;
    private List<Factura> facturas;
    private List<Pago> pagos;
}
