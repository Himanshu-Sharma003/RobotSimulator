package com.assignment.commands.impl;

import com.assignment.commands.CommandRegister;
import com.assignment.commands.Commands;
import com.assignment.common.model.Direction;
import com.assignment.common.exception.InvalidMovementException;
import com.assignment.common.model.Coordinates;
import com.assignment.common.model.Position;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Right  implements Commands {

    private CommandRegister register;

    public Right(CommandRegister register){
        this.register = register;
        this.register.register(this);
    }

    public String getCommand() {
        return "RIGHT";
    }

    public Position execute(Coordinates coordinates, Direction direction) throws InvalidMovementException {
        Position position = new Position(coordinates,direction.moveRight());
        return position;
    }
}
