package com.tutor.ti_kolb.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

public record KolbTestRequestDTO(@NotNull(message = "UserId não pode ser nulo") UUID userId,
                @NotNull(message = "Respostas não podem ser nulas") @Size(min = 48, max = 48, message = "Devem ser exatamente 48 respostas") List<Integer> answers,
                @NotNull(message = "O nome não pode ser vazio") String name) {
}