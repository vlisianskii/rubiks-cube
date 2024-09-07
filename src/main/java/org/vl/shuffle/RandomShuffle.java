package org.vl.shuffle;

import org.vl.cube.RubiksCube;
import org.vl.cube.Side;
import org.vl.cube.Direction;

import static org.vl.utils.RandomUtils.*;

public abstract class RandomShuffle extends ConditionalShuffle {
    @Override
    protected Side getSide(RubiksCube cube) {
        return Side.values()[randomOrdinalOfEnum(Side.class)];
    }

    @Override
    protected int getIndex(RubiksCube cube) {
        return randomNumberBetween(0, cube.getSize());
    }

    @Override
    protected Direction getDirection(RubiksCube cube) {
        return Direction.values()[randomOrdinalOfEnum(Direction.class)];
    }
}
