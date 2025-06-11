package com.tutor.ti_kolb.dtos;

import java.util.List;
import java.util.UUID;

public record KolbTestMessageDTO(UUID userId, List<Integer> answers) {

}
