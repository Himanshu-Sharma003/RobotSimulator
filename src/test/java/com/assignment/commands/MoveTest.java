package com.assignment.commands;

import com.assignment.commands.impl.Move;
import com.assignment.common.exception.InvalidMovementException;
import com.assignment.common.model.Coordinates;
import com.assignment.common.model.Direction;
import com.assignment.common.model.Position;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoveTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testExecuteSuccess() throws InvalidMovementException {
        Coordinates coordinates = new Coordinates(0, 0);
        Direction north = Direction.NORTH;
        Move command = new Move();
        Position position = command.execute(coordinates, north);
        Assert.assertSame(position.getCoordinates().getCordX(), 0);
        Assert.assertSame(position.getCoordinates().getCordY(), 1);
    }

    @Test
    public void testExecuteFailure() throws InvalidMovementException {
        exceptionRule.expect(InvalidMovementException.class);
        exceptionRule.expectMessage("Invalid command MOVE to coordinates 0 and -1");
        Coordinates coordinates = new Coordinates(0, 0);
        Direction north = Direction.SOUTH;
        Move command = new Move();
        Position position = command.execute(coordinates, north);

    }
}
