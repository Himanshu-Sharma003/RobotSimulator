package com.assignment.common.exception;

import com.assignment.common.model.Coordinates;

/**
 * The type Invalid movement exception.
 */
public class InvalidMovementException extends Exception {

    private static final String ERR_MSG = "Invalid command %s to coordinates %s and %s";
    /**
     * The Constant serialVersionUID.
     **/
    private static final long serialVersionUID = 1L;


    /**
     * Instantiates a new Invalid movement exception.
     *
     * @param message the message
     */
    public InvalidMovementException(String message) {
        super(message);
    }


    /**
     * Instantiates a new Invalid movement exception.
     *
     * @param command    the command
     * @param coordinates the coordinates
     */
    public InvalidMovementException(String command, Coordinates coordinates) {
        super(String.format(ERR_MSG, command, coordinates.getCordX(),coordinates.getCordY()));
    }


    /**
     * Instantiates a new Invalid movement exception.
     *
     * @param message  the message
     * @param operator the operator
     */
    public InvalidMovementException(String message, String operator) {
        super(String.format(message, operator));
    }

}
