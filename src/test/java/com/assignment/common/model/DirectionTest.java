package com.assignment.common.model;

import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {
    @Test
    public void testDirection()  {
        Direction direction = Direction.EAST;
        direction = direction.moveLeft();
        Assert.assertEquals(direction, Direction.NORTH);

        direction = direction.moveRight();
        Assert.assertEquals(direction, Direction.EAST);

        direction =  direction.moveRight();
        Assert.assertEquals(direction, Direction.SOUTH);

        direction =  direction.moveRight();
        Assert.assertEquals(direction, Direction.WEST);

        direction = direction.moveRight();
        Assert.assertEquals(direction, Direction.NORTH);

    }
}
