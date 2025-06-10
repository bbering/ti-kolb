package com.tutor.ti_kolb.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor.ti_kolb.dtos.KolbResultDTO;

@RestController
@RequestMapping("/api/v1/kolb")
public class KolbController {
    
    @PostMapping
    public ResponseEntity<KolbResultDTO> doTest(){
        // implementação do metodo post
    }

}
