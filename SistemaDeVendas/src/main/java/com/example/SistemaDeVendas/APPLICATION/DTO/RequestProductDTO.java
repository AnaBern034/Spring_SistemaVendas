package com.example.SistemaDeVendas.APPLICATION.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RequestProductDTO(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        Integer amout,
        @NotNull
        Float price,

        BigDecimal totalPrice
) {

}
