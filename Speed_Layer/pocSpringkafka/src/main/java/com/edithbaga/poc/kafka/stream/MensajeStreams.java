package com.edithbaga.poc.kafka.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MensajeStreams {

    String INPUT = "mensaje-in";
    String OUTPUT = "mensaje-out";

    @Input(INPUT)
    SubscribableChannel mensajeEntrante();

    @Output(OUTPUT)
    MessageChannel mensajeSaliente();
}
