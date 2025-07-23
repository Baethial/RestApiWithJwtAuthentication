package com.acm.HotelManagementApp.controller.dto;

import jakarta.validation.constraints.*;
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
public class PagoDTO {

    @NotBlank(message = "Payment method cannot be blank")
    @NotNull(message = "Payment method cannot be null")
    @Pattern(regexp = "^(EFECTIVO|TARJETA_CREDITO|TARJETA_DEBITO|TRANSFERENCIA)$",
            message = "Payment method must be: EFECTIVO, TARJETA_CREDITO, TARJETA_DEBITO, or TRANSFERENCIA")
    private String metodoPago;

    @NotBlank(message = "Payment amount cannot be blank")
    @NotNull(message = "Payment amount cannot be null")
    @DecimalMin(value = "0.01", message = "Payment amount must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Invalid payment amount format")
    private BigDecimal pagoTotal;

    @NotBlank(message = "Reservation ID cannot be blank")
    @NotNull(message = "Reservation ID cannot be null")
    @Positive(message = "Reservation ID must be positive")
    private Long idReserva;

    // Optional?

    private LocalDateTime fecha;
    private Long idFactura;
}
