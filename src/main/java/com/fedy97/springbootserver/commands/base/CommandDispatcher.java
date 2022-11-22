package com.fedy97.springbootserver.commands.base;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandDispatcher {
    protected Map<Class, CommandExecutor> preparedMap = new HashMap<>();

    public <C extends Command, R extends CommandResponse> R dispatch(C command) {
        return (R) preparedMap.get(command.getClass()).execute(command);
    }
}
