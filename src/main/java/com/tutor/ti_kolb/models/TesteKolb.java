package com.tutor.ti_kolb.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @ElementCollection
    @CollectionTable(name = "respostas_kolb", joinColumns = @JoinColumn(name = "teste_id"))
    @Column(name = "resposta")
    private List<Integer> respostas;

    @Column(nullable = false)
    private String perfil; // assimilador, convergente...

    @Column(nullable = false)
    private LocalDateTime dataResposta;
}
