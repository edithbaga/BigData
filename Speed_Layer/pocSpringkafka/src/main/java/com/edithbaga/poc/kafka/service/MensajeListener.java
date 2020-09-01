package com.edithbaga.poc.kafka.service;

import com.edithbaga.poc.kafka.model.Mensaje;
import com.edithbaga.poc.kafka.stream.MensajeStreams;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;



@Component
@Slf4j
public class MensajeListener {

    private static final Logger logger = LoggerFactory.getLogger(MensajeService.class);

    @StreamListener(MensajeStreams.INPUT)
    public void manejarSaludos(@Payload final Mensaje mensaje) {
        logger.info("Recibimos el Mensaje: {}", mensaje);
    }
}
