package com.assignment.common.exception;

/**
 * The type Invalid direction.
 */
public class InvalidDirection extends Exception {
    private static final String ERR_MSG = "Invalid command: {}.";
    /**
     * The Constant serialVersionUID.
     **/
    private static final long serialVersionUID = 1L;


    /**
     * Instantiates a new Invalid direction.
     */
    public InvalidDirection() {
        super("Invalid Direction");
    }


    /**
     * Instantiates a new Invalid direction.
     *
     * @param message   the message
     * @param direction the direction
     */
    public InvalidDirection(String message, String direction) {
        super(String.format(message, direction));
    }

}

