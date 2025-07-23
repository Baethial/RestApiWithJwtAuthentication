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
public class Factura {

    private Long id;
    private LocalDateTime fechaEmision;
    private BigDecimal valorTotal;
    private Pago pago;
    private Reserva reserva;
}
