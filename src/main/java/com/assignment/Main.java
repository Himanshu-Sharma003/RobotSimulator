package com.assignment;

import com.assignment.commands.CommandRegister;
import com.assignment.commands.impl.Left;
import com.assignment.commands.impl.Move;
import com.assignment.commands.impl.Place;
import com.assignment.commands.impl.Right;
import com.assignment.common.Board;
import com.assignment.common.Robot;
import com.assignment.common.exception.InvalidCommand;
import com.assignment.common.exception.InvalidDirection;
import com.assignment.common.exception.InvalidMovementException;
import com.assignment.common.model.Coordinates;
import com.assignment.common.model.Direction;
import com.assignment.common.model.Position;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * The type Main.
 */
@Slf4j
public class Main {

    // Board
    private static Board board;
    // Robot
    private static Robot robot;

    /**
     * Event Register.
     */
    private static CommandRegister commandRegister;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        setUp();
        // Load logging configuration
        registerCommand();
        log.info("Please enter instruction for robot");
        try {
            processInput();
        } catch (Exception e) {
            log.info("Something went wrong, please try again...");
        }
    }

    /**
     *
     */
    private static void setUp() {
        // Initialized Board dimension.
        board = new Board(new Coordinates(5, 5));
        // Initialize Robot.
        Position position = new Position(new Coordinates(0, 0), Direction.NORTH);
        robot = new Robot(position);
    }


    private static void processInput() throws InvalidDirection {
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            final String text = scanner.nextLine();
            if (StringUtils.isBlank(text)) {
                log.info("Please enter valid instruction");
                continue;
            }
            if (text.toUpperCase().contains("EXIT")) {
                break;
            }
            if (text.toUpperCase().contains("REPORT")) {
                log.info("OUTPUT:{},{},{}", robot.getPosition().getCoordinates().getCordX(),
                        robot.getPosition().getCoordinates().getCordY(), robot.getPosition().getDirection());
                continue;
            }
            String[] inputs = text.split(" ");
            // Invoke Operator
            Coordinates coordinates = robot.getPosition().getCoordinates();
            Direction dir = robot.getPosition().getDirection();
            if (inputs.length > 1 && StringUtils.isNotBlank(inputs[1])) {
                String[] position = inputs[1].split(",");
                if (position.length < 3) {
                    log.info("Invalid Instruction, insufficient inputs");
                    continue;
                }
                coordinates = new Coordinates(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
                dir = Direction.valueOf(position[2].charAt(0));
            }
            try {
                Position newPosition = commandRegister.getCommand(inputs[0]).execute(coordinates, dir);
                if (board.isValid(newPosition.getCoordinates())) {
                    robot.setPosition(newPosition);
                } else {
                    log.info("Robot cannot move there ...!");
                }
            } catch (InvalidMovementException | InvalidCommand e) {
                log.info(e.getMessage());
            }
        }
        log.info("Bye .......!");
        scanner.close();
    }

    /**
     * Registers operator with OperatorRegister which auto discovery of Operator.
     */
    private static void registerCommand() {
        commandRegister = new CommandRegister();
        // Registering LEFT Command.
        new Left(commandRegister);
        // Registering RIGHT Command.
        new Right(commandRegister);
        // Registering MOVE Command.
        new Move(commandRegister);
        // Place
        new Place(commandRegister);
    }

}
