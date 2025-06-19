package com.tutor.ti_kolb.controllers;

import com.tutor.ti_kolb.dtos.KolbResultDTO;
import com.tutor.ti_kolb.dtos.KolbTestRequestDTO;
import com.tutor.ti_kolb.dtos.ReceivedUserObjectDTO;
import com.tutor.ti_kolb.services.TesteKolbService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kolb")
@Tag(name = "Teste Kolb", description = "Endpoints para execução do teste de estilos de aprendizagem de Kolb.")
public class KolbController {

    private final TesteKolbService testService;

    public KolbController(TesteKolbService testeKolbService) {
        this.testService = testeKolbService;
    }

    @Operation(
        summary = "Submeter respostas do teste Kolb",
        description = "Processa as respostas do usuário para o teste de estilos de aprendizagem de Kolb e retorna o resultado.",
        responses = {
            @ApiResponse(responseCode = "201", description = "Teste processado com sucesso",
                content = @Content(schema = @Schema(implementation = KolbResultDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos",
                content = @Content)
        }
    )
    @PostMapping("/test")
    public ResponseEntity<KolbResultDTO> doTest(@Valid @RequestBody KolbTestRequestDTO kolbTestData) {
        KolbResultDTO methodAnswer = testService.makeTest(kolbTestData.userId(), kolbTestData.answers());
        return new ResponseEntity<>(methodAnswer, HttpStatus.CREATED);
    }

    @Operation(
        summary = "Simular recepção via RabbitMQ",
        description = "Simula o recebimento de um objeto de usuário como se fosse recebido via fila (ex: RabbitMQ). Útil para testes.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário simulado recebido e salvo com sucesso",
                content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                content = @Content)
        }
    )
    @PostMapping("/mock-rabbit")
    public ResponseEntity<String> mockRabbitReception(@RequestBody ReceivedUserObjectDTO userDto) {
        testService.saveInitialUser(userDto.userId(), userDto.name());
        return ResponseEntity.ok("Usuário recebido e salvo com sucesso.");
    }
}