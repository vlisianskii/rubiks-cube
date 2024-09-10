package org.vl.shuffler;

import org.vl.cube.Rotation;
import org.vl.cube.RubiksCube;

public abstract class BaseRotation {
    public int rotate(RubiksCube cube) {
        int times = 0;
        while (!condition(cube, times)) {
            times++;

            Rotation rotation = rotation(cube, times);
            System.out.printf("<%s> rotation - <%s:%s:%s>\n", times, rotation.getSide(), rotation.getIndex(), rotation.getDirection());

            cube.rotate(rotation);
            cube.print();
            System.out.println();
        }
        return times;
    }

    protected abstract Rotation rotation(RubiksCube cube, int times);
    protected abstract boolean condition(RubiksCube cube, int times);
}
