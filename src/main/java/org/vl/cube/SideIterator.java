package org.vl.cube;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.reverse;

public class SideIterator {
    private static final Map<Side, Map<Direction, List<Side>>> DIRECTIONS = Map.of(
            Side.TOP, Map.of(
                    Direction.UP, List.of(Side.BACK, Side.BOTTOM, Side.MAIN),
                    Direction.LEFT, List.of(Side.LEFT, Side.BOTTOM, Side.RIGHT)
            ),
            Side.MAIN, Map.of(
                    Direction.UP, List.of(Side.TOP, Side.BACK, Side.BOTTOM),
                    Direction.LEFT, List.of(Side.LEFT, Side.BACK, Side.RIGHT)
            ),
            Side.LEFT, Map.of(
                    Direction.UP, List.of(Side.TOP, Side.RIGHT, Side.BOTTOM),
                    Direction.LEFT, List.of(Side.BACK, Side.RIGHT, Side.MAIN)
            ),
            Side.RIGHT, Map.of(
                    Direction.UP, List.of(Side.TOP, Side.LEFT, Side.BOTTOM),
                    Direction.LEFT, List.of(Side.MAIN, Side.LEFT, Side.BACK)
            ),
            Side.BACK, Map.of(
                    Direction.UP, List.of(Side.BOTTOM, Side.MAIN, Side.TOP),
                    Direction.LEFT, List.of(Side.RIGHT, Side.MAIN, Side.LEFT)
            ),
            Side.BOTTOM, Map.of(
                    Direction.UP, List.of(Side.MAIN, Side.TOP, Side.BACK),
                    Direction.LEFT, List.of(Side.LEFT, Side.TOP, Side.RIGHT)
            )
    );

    public static List<Side> getSides(Side side, Direction direction) {
        return switch (direction) {
            case UP, LEFT -> DIRECTIONS.get(side).get(direction);
            case RIGHT -> reverse(DIRECTIONS.get(side).get(Direction.LEFT));
            case DOWN -> reverse(DIRECTIONS.get(side).get(Direction.UP));
        };
    }
}
