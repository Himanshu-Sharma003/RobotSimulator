package com.assignment.commands;

import com.assignment.common.model.Direction;
import com.assignment.common.exception.InvalidMovementException;
import com.assignment.common.model.Coordinates;
import com.assignment.common.model.Position;

/**
 * The interface Commands.
 */
public interface Commands {

    String getCommand();
    /**
     * Move coordinates.
     *
     * @param coordinates the coordinates
     * @param direction the direction
     * @return the coordinates
     */
    Position execute(Coordinates coordinates, Direction direction) throws InvalidMovementException;
}
