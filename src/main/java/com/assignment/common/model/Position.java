package com.assignment.common.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Position {
    //Position.
    private Coordinates coordinates;
    //Direction.
    private Direction direction;
}
