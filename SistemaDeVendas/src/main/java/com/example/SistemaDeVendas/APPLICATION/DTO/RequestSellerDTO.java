package com.example.SistemaDeVendas.APPLICATION.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestSellerDTO(
        @NotBlank
        @NotNull
        String name,
        @NotNull
        @NotBlank
        @Email
        String email,
        @NotNull
        @NotBlank
        String cpf,
        @NotNull
        Float salary
){
}
