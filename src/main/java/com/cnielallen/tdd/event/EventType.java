package com.cnielallen.tdd.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EventType {
    @JsonProperty("Create")
    CREATE,
    @JsonProperty
    UPDATE;

    private  EventType(){
        
    }
}
