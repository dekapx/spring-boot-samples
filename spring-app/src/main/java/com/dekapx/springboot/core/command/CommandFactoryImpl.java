package com.dekapx.springboot.core.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class CommandFactoryImpl implements CommandFactory {
    private List<Command> commands;

    @Autowired
    public CommandFactoryImpl(final List<Command> commands) {
        this.commands = List.copyOf(commands);
    }

    @Override
    public Command getCommand(final CommandType commandType) {
        return this.commands
                .stream()
                .filter(isMatchingCommand(commandType))
                .findFirst()
                .get();
    }

    private Predicate<Command> isMatchingCommand(final CommandType commandType) {
        return command -> command.getClass().getTypeName().equals(commandType.toString());
    }
}
