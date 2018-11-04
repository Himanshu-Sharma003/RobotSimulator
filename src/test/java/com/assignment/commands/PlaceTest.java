package com.assignment.commands;

import com.assignment.commands.impl.Move;
import com.assignment.commands.impl.Place;
import com.assignment.common.exception.InvalidMovementException;
import com.assignment.common.model.Coordinates;
import com.assignment.common.model.Direction;
import com.assignment.common.model.Position;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PlaceTest {
    @Test
    public void testExecute() throws InvalidMovementException {
        Coordinates coordinates = new Coordinates(0, 0);
        Direction north = Direction.NORTH;
        Place command = new Place();
        Position position = command.execute(coordinates, north);
        Assert.assertSame(position.getCoordinates().getCordX(), 0);
        Assert.assertSame(position.getCoordinates().getCordY(), 0);
    }

}
