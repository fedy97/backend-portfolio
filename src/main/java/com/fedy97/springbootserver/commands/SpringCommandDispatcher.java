package com.fedy97.springbootserver.commands;

import com.fedy97.springbootserver.commands.base.CommandDispatcher;
import com.fedy97.springbootserver.commands.base.CommandExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

@Service
@Slf4j
public class SpringCommandDispatcher extends CommandDispatcher {
    private final Map<String, CommandExecutor> rawMap;

    public SpringCommandDispatcher(Map<String, CommandExecutor> rawMap) {
        log.info(rawMap.toString());
        this.rawMap = rawMap;
    }

    @PostConstruct
    private void setUp() {
        if (rawMap != null && !rawMap.isEmpty()) {
            for (CommandExecutor commandExecutor : rawMap.values()) {
                Type command = ((ParameterizedType)commandExecutor.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
                preparedMap.put((Class) command, commandExecutor);
            }
        }
    }
}
