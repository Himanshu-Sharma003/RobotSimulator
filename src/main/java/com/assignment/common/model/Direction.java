package com.assignment.common.model;

import com.assignment.common.exception.InvalidDirection;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Direction.
 */
public enum Direction {

    /**
     * North direction.
     */
    NORTH('N'),
    /**
     * East direction.
     */
    EAST('E'),
    /**
     * South direction.
     */
    SOUTH('S'),
    /**
     * West direction.
     */
    WEST('W');

    private Character direction;

    /**
     *
     */
    private static Map<Character, Map<Character, Direction>> map = new HashMap();
    /**
     * The constant LEFT.
     */
    public static final Character LEFT = 'L';

    /**
     * The constant RIGHT.
     */
    public static final Character RIGHT = 'R';


    static {
        //NORTH
        setDirection(WEST, EAST, NORTH);
        //SOUTH
        setDirection(EAST, WEST, SOUTH);
        //EAST
        setDirection(NORTH, SOUTH, EAST);
        //WEST
        setDirection(SOUTH, NORTH, WEST);


    }

    Direction(Character direction) {
        this.direction = direction;
    }


    /**
     * Left direction direction.
     *
     * @return the direction
     */
    public Direction moveLeft() {
        return map.get(this.direction).get(LEFT);
    }

    /**
     * Right direction direction.
     *
     * @return the direction
     */
    public Direction moveRight() {
        return map.get(this.direction).get(RIGHT);
    }

    private static void setDirection(Direction leftDir, Direction rightDir, Direction dir) {
        Map<Character, Direction> hashMap = new HashMap<Character, Direction>();
        hashMap.put(LEFT, leftDir);
        hashMap.put(RIGHT, rightDir);
        hashMap.put(dir.direction, dir);
        map.put(dir.direction, hashMap);
    }

    public static Direction valueOf(Character chr) throws InvalidDirection {
        Direction direction = map.get(chr).get(chr);
        if (direction == null)
            throw new InvalidDirection();
        return direction;
    }

}
