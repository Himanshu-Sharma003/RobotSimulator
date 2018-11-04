package com.assignment.commands.impl;

import com.assignment.commands.CommandRegister;
import com.assignment.commands.Commands;
import com.assignment.common.model.Direction;
import com.assignment.common.exception.InvalidMovementException;
import com.assignment.common.model.Coordinates;
import com.assignment.common.model.Position;
import lombok.NoArgsConstructor;

/**
 * .
 */
@NoArgsConstructor
public class Move implements Commands {

    private CommandRegister register;

    public Move(CommandRegister register) {
        this.register = register;
        this.register.register(this);
    }

    public String getCommand() {
        return "MOVE";
    }


    public Position execute(Coordinates coordinates, Direction direction) throws InvalidMovementException {
        Coordinates newCoordinates = null;
        switch (direction) {
            case NORTH:
                newCoordinates = new Coordinates(coordinates.getCordX(), coordinates.getCordY() + 1);
                break;
            case SOUTH:
                newCoordinates = new Coordinates(coordinates.getCordX(), coordinates.getCordY() - 1);
                break;
            case WEST:
                newCoordinates = new Coordinates(coordinates.getCordX() - 1, coordinates.getCordY());
                break;
            case EAST:
                newCoordinates = new Coordinates(coordinates.getCordX() + 1, coordinates.getCordY());
                break;
        }

        if (!isValid(newCoordinates)) {
            throw new InvalidMovementException("MOVE", newCoordinates);
        }
        Position position = new Position(newCoordinates, direction);
        return position;
    }

    private boolean isValid(Coordinates coordinates) {
        if ((coordinates.getCordX() < 0 || coordinates.getCordY() < 0)) {
            return false;
        }
        return true;
    }
}
