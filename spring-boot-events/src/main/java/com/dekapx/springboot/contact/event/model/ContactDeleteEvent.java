package com.dekapx.springboot.contact.event.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ContactDeleteEvent{
    private String event;
}
