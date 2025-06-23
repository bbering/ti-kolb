package com.tutor.ti_kolb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record KolbTestRequestDTO(
        @Schema(description = "Identificador único do usuário", example = "550e8400-e29b-41d4-a716-446655440000") @NotNull(message = "UserId não pode ser nulo") UUID userId,

        @Schema(description = "Lista de 48 respostas do teste de Kolb", example = "[1, 2, 3, ..., 4]") @NotNull(message = "Respostas não podem ser nulas") @Size(min = 48, max = 48, message = "Devem ser exatamente 48 respostas") List<Integer> answers,

        @Schema(description = "Nome do usuário que realizou o teste", example = "João da Silva") @NotNull(message = "O nome não pode ser vazio") String name) {
}
