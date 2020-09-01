package com.edithbaga.poc.kafka.config;


import com.edithbaga.poc.kafka.stream.MensajeStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = MensajeStreams.class)
public class StreamsConfig {

}
