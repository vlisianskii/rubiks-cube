package org.vl.shuffle;

import org.vl.cube.RubiksCube;

public class Solver extends RandomShuffle {
    @Override
    protected boolean condition(RubiksCube cube, int times) {
        return cube.isSolved();
    }
}
