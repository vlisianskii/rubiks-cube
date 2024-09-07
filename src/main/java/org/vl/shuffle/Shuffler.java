package org.vl.shuffle;

import lombok.AllArgsConstructor;
import org.vl.cube.RubiksCube;

@AllArgsConstructor
public class Shuffler extends RandomShuffle {
    private final int n;

    @Override
    protected boolean condition(RubiksCube cube, int times) {
        return times >= n;
    }
}
