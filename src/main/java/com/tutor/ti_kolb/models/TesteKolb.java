package com.tutor.ti_kolb.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "testes_kolb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TesteKolb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String respostasJson;

    @Column(nullable = false)
    private String perfil; // assimilador, convergente...

    @Column(nullable = false)
    private LocalDateTime dataResposta;
}
