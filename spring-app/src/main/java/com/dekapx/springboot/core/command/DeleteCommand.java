package com.dekapx.springboot.core.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeleteCommand implements Command<String, String> {
    @Override
    public String execute(String request) {
        return null;
    }
}
