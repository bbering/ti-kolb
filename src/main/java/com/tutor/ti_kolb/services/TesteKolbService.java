package com.tutor.ti_kolb.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        TesteKolb testToSave = new TesteKolb();
        ObjectMapper mapper = new ObjectMapper();

        testToSave.setUserId(userUuid);
        testToSave.setDataResposta(LocalDateTime.now());

        try {
            String respostasJson = mapper.writeValueAsString(answers);
            testToSave.setRespostasJson(respostasJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro no processo de serializar respostas: ", e);
        }

        testToSave.setPerfil(calcularPerfilKolb(answers));
        kolbRepository.save(testToSave);

        return new KolbResultDTO(testToSave.getUserId(), testToSave.getPerfil());
    }

    // metodo utilizado para criar testes parciais
    public void saveInitialUser(UUID userId, String name) {
        Optional<TesteKolb> existing = kolbRepository.findByUserId(userId);
        if (existing.isPresent()) {
            // user já existe, nao é necessário salvar
            return;
        }

        TesteKolb novoTeste = new TesteKolb();
        novoTeste.setUserId(userId);
        novoTeste.setName(name);
        kolbRepository.save(novoTeste);
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
