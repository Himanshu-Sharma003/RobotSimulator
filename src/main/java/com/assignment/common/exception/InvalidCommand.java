package com.assignment.common.exception;

/**
 * The type Invalid command.
 */
public class InvalidCommand extends Exception {
    private static final String ERR_MSG = "Invalid command: %s.";
    /**
     * The Constant serialVersionUID.
     **/
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Invalid command.
     */
    public InvalidCommand() {
        super("Invalid Command");
    }

    /**
     * Instantiates a new Invalid command.
     *
     * @param command the command
     */
    public InvalidCommand(String command) {
        super(String.format(ERR_MSG, command));
    }


    /**
     * Instantiates a new Invalid command.
     *
     * @param message  the message
     * @param command the command
     */
    public InvalidCommand(String message, String command) {
        super(String.format(message, command));
    }

}
