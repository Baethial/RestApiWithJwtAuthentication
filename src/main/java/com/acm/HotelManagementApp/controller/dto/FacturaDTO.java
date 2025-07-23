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
public class FacturaDTO {

    @NotBlank(message = "Payment method cannot be blank")
    @NotNull(message = "Payment ID cannot be null")
    @Positive(message = "Payment ID must be positive")
    private Long idPago;

    @NotBlank(message = "Reservation number cannot be blank")
    @NotNull(message = "Reservation ID cannot be null")
    @Positive(message = "Reservation ID must be positive")
    private Long idReserva;

    @NotBlank(message = "Total value cannot be blank")
    @NotNull(message = "Total value cannot be null")
    @DecimalMin(value = "0.01", message = "Payment amount must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Invalid payment amount format")
    private BigDecimal valorTotal;

    // Optional?

    private LocalDateTime fechaEmision;
}
