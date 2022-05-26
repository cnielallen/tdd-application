package com.cnielallen.tdd.event;

public class EventHeaderGenerator {
    public static EventHeader randomEventHeader(String objName){
        return EventHeader.builder()
                .eventType(EventType.CREATE)
                .objectName(objName)
                .build();
    }
}
