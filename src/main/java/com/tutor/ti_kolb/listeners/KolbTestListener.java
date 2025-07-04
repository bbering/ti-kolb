package com.tutor.ti_kolb.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.tutor.ti_kolb.dtos.ReceivedUserObjectDTO;
import com.tutor.ti_kolb.services.TesteKolbService;

@Component
public class KolbTestListener {

    private final TesteKolbService testeKolbService;

    public KolbTestListener(TesteKolbService testeKolbService) {
        this.testeKolbService = testeKolbService;
    }

    @RabbitListener(queues = "${kolb.queue.name}")
    public void receiveMessage(ReceivedUserObjectDTO dto) {
        testeKolbService.saveInitialUser(dto.userId(), dto.name());
    }

}
