package org.vl.shuffler.solver;

import org.vl.cube.RubiksCube;
import org.vl.shuffler.BaseRotation;

public abstract class AbstractSolver extends BaseRotation {
    @Override
    protected boolean condition(RubiksCube cube, int times) {
        return cube.isSolved();
    }
}
