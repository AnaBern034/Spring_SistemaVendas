package com.example.SistemaDeVendas.APPLICATION.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestCostumerDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String address,
        @NotBlank
        String cpf
){ }
