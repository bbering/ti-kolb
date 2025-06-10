package com.tutor.ti_kolb.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.tutor.ti_kolb.dtos.KolbResultDTO;
import com.tutor.ti_kolb.models.TesteKolb;
import com.tutor.ti_kolb.repositories.KolbRepository;

public class TesteKolbService {

    private final KolbRepository kolbRepository;

    public TesteKolbService(KolbRepository kolbRepository) {
        this.kolbRepository = kolbRepository;
    }

    public KolbResultDTO makeTest(UUID userUuid, List<Integer> answers) {
        /*
         * aqui é implementado o metodo que consumirá o json recebido via fila
         */

        // instanciar a entidade
        TesteKolb testToSave = new TesteKolb();

        // aqui será mockado um userID ainda não-real
        testToSave.setId(userUuid);

        // criação de uma variavel para capturar o momento em que o teste é respondido
        // no horario local
        LocalDateTime answerTime = LocalDateTime.now();
        testToSave.setDataResposta(answerTime);

        testToSave.setRespostas(answers);

        // aqui o resultado do metodo auxiliar será passado e o perfil setado ao fim do
        // cálculo
        testToSave.setPerfil(null);

        // montar o DTO para ser retornado ao criar um novo teste e evitar expor dados
        // sensiveis
        return new KolbResultDTO(testToSave.getUserId(), testToSave.getPerfil());
    }

}
