package com.edithbaga.poc.kafka.service;

import com.edithbaga.poc.kafka.model.Mensaje;
import com.edithbaga.poc.kafka.stream.MensajeStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@Slf4j
public class MensajeService {

    private static final Logger logger = LoggerFactory.getLogger(MensajeService.class);

    private final MensajeStreams mensajeStreams ;

    public MensajeService(final MensajeStreams mensajeStreams) {
        this.mensajeStreams = mensajeStreams;
    }

    public void sendGreeting(final Mensaje mensaje) {

        logger.info("Recibimos Saludos: {}", mensaje);
        final MessageChannel messageChannel = mensajeStreams.mensajeSaliente();
        messageChannel.send(MessageBuilder
                .withPayload(mensaje)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}

