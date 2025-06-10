package com.tutor.ti_kolb.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tutor.ti_kolb.dtos.KolbResultDTO;
import com.tutor.ti_kolb.models.TesteKolb;
import com.tutor.ti_kolb.repositories.KolbRepository;

@Service
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
        testToSave.setPerfil(calcularPerfilKolb(answers));

        kolbRepository.save(testToSave);

        // montar o DTO para ser retornado ao criar um novo teste e evitar expor dados
        // sensiveis
        return new KolbResultDTO(testToSave.getUserId(), testToSave.getPerfil());
    }

    public String calcularPerfilKolb(List<Integer> respostas) {
        // a lista de respostas deve conter 48 entradas, (12 perguntas com 4
        // alternativas, 12x4= 48)
        if (respostas == null || respostas.size() != 48) {
            throw new IllegalArgumentException("A lista de respostas deve conter exatamente 48 valores.");
        }

        int ce = 0; // concreto experiencial
        int ro = 0; // reflexivo observador
        int ac = 0; // abstrato conceitual
        int ae = 0; // ativo experimental

        // respostas organizadas em blocos de 4 alternativas
        for (int i = 0; i < 48; i += 4) {
            ce += respostas.get(i);
            ro += respostas.get(i + 1);
            ac += respostas.get(i + 2);
            ae += respostas.get(i + 3);
        }

        int diffAE_RO = ae - ro;
        int diffCE_AC = ce - ac;

        // avaliação final do perfil do usuario
        if (diffAE_RO >= 0 && diffCE_AC >= 0) {
            return "Acomodador";
        } else if (diffAE_RO >= 0 && diffCE_AC < 0) {
            return "Convergente";
        } else if (diffAE_RO < 0 && diffCE_AC >= 0) {
            return "Divergente";
        } else {
            return "Assimilador";
        }
    }

}
