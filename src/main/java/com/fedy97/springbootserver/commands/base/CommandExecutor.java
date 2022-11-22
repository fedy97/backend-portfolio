package com.fedy97.springbootserver.commands.base;

public interface CommandExecutor<C extends Command, R extends CommandResponse> {
    R execute(C command);
}
