package com.assignment.commands;

import com.assignment.common.exception.InvalidCommand;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
public class CommandRegister {
    private Map<String, Commands> commandsMap = new HashMap<String, Commands>();

    public void register(final Commands operator) {
        this.commandsMap.put(operator.getCommand(), operator);
    }

    public Commands getCommand(final String cmdStr) throws InvalidCommand {
        if(StringUtils.isBlank(cmdStr)){
            throw new InvalidCommand();
        }
        final Commands commands = commandsMap.get(cmdStr.toUpperCase());
        if (commands == null) {
            throw new InvalidCommand(cmdStr);
        }
        return commands;
    }

}
