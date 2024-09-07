package org.vl.shuffle;

import org.vl.cube.RubiksCube;
import org.vl.cube.Side;
import org.vl.cube.Direction;

public abstract class ConditionalShuffle {
    public void shuffle(RubiksCube cube) {
        int times = 0;
        while (!condition(cube, times)) {
            cube.rotate(getSide(), getIndex(cube), getDirection());
            System.out.printf("<%s> times\n\n", times);
            times++;
        }
    }

    protected abstract Side getSide();
    protected abstract int getIndex(RubiksCube cube);
    protected abstract Direction getDirection();
    protected abstract boolean condition(RubiksCube cube, int times);
}
