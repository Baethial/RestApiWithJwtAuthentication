package com.acm.HotelManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    private Long id;
    private LocalDateTime fecha;
    private String metodoPago;
    private BigDecimal pagoTotal;
    private Reserva reserva;
    private Factura factura;
}
