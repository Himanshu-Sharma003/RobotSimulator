package com.assignment.common;

import com.assignment.common.model.Coordinates;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Board.
 */
@Slf4j
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Board {

    // Board Dimension
    private Coordinates dimensions;

    /**
     * Check if input co-ordinates are valid for the board.
     *
     * @param coordinates
     * @return
     */
    public boolean isValid(Coordinates coordinates) {
        return !(this.dimensions.getCordX() < coordinates.getCordX() ||
                this.dimensions.getCordY() < coordinates.getCordY() );
    }
}
