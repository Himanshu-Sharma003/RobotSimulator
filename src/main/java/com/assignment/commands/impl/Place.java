package com.assignment.commands.impl;

import com.assignment.commands.CommandRegister;
import com.assignment.commands.Commands;
import com.assignment.common.exception.InvalidMovementException;
import com.assignment.common.model.Coordinates;
import com.assignment.common.model.Direction;
import com.assignment.common.model.Position;
import lombok.NoArgsConstructor;

/**
 * The type Place.
 */
@NoArgsConstructor
public class Place implements Commands {

    /**
     * The constant PLACE.
     */
    public static final String PLACE = "PLACE";
    private CommandRegister register;

    /**
     * Instantiates a new Place.
     *
     * @param register the register
     */
    public Place(final CommandRegister register) {
        this.register = register;
        this.register.register(this);
    }

    public String getCommand() {
        return PLACE;
    }


    public Position execute(Coordinates coordinates, Direction direction) throws InvalidMovementException {
        Position position = new Position(coordinates, direction);
        return position;
    }
}
