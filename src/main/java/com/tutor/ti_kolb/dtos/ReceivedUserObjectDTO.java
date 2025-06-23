package com.tutor.ti_kolb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record ReceivedUserObjectDTO(
        @Schema(description = "Identificador único do usuário", example = "550e8400-e29b-41d4-a716-446655440000") UUID userId,

        @Schema(description = "Nome do usuário", example = "Maria Oliveira") String name) {
}
