package com.edithbaga.poc.kafka.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Mensaje {

    private long timestamp;
    private String message;

}
