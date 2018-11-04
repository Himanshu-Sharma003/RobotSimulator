package com.assignment.commands;

import com.assignment.commands.impl.Left;
import com.assignment.commands.impl.Move;
import com.assignment.common.exception.InvalidMovementException;
import com.assignment.common.model.Coordinates;
import com.assignment.common.model.Direction;
import com.assignment.common.model.Position;
import org.junit.Assert;
import org.junit.Test;

public class LeftTest {

    @Test
    public void testExecuteSuccess() throws InvalidMovementException {
        Coordinates coordinates = new Coordinates(0, 0);
        Direction north = Direction.NORTH;
        Left command = new Left();
        Position position = command.execute(coordinates, north);
        Assert.assertEquals(position.getDirection(),Direction.WEST );
    }

}
