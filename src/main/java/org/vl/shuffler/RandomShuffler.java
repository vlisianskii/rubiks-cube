package org.vl.shuffler;

import lombok.AllArgsConstructor;
import org.vl.cube.Direction;
import org.vl.cube.Rotation;
import org.vl.cube.RubiksCube;
import org.vl.cube.Side;

import static org.vl.utils.RandomUtils.randomNumberBetween;
import static org.vl.utils.RandomUtils.randomOrdinalOfEnum;

@AllArgsConstructor
public class RandomShuffler extends Shuffler {
    private final int n;

    @Override
    protected Rotation rotation(RubiksCube cube, int times) {
        return Rotation.builder()
                .side(Side.values()[randomOrdinalOfEnum(Side.class)])
                .index(randomNumberBetween(0, cube.getSize() - 1))
                .direction(Direction.values()[randomOrdinalOfEnum(Direction.class)])
                .build();
    }

    @Override
    protected boolean condition(RubiksCube cube, int times) {
        return times >= n;
    }
}
