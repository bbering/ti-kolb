package com.tutor.ti_kolb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor.ti_kolb.dtos.KolbResultDTO;
import com.tutor.ti_kolb.dtos.KolbTestRequestDTO;
import com.tutor.ti_kolb.services.TesteKolbService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/kolb")
public class KolbController {

    private final TesteKolbService testService;

    public KolbController(TesteKolbService testeKolbService) {
        this.testService = testeKolbService;
    }

    @PostMapping("/test")
    public ResponseEntity<KolbResultDTO> doTest(@Valid @RequestBody KolbTestRequestDTO kolbTestData) {
        KolbResultDTO methodAnswer = testService.makeTest(kolbTestData.userId(), kolbTestData.answers());
        return new ResponseEntity<>(methodAnswer, HttpStatus.CREATED);
    }

}
