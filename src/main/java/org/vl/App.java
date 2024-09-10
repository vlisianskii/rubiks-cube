package org.vl;

import org.vl.cube.RubiksCube;
import org.vl.shuffler.RandomShuffler;
import org.vl.shuffler.solver.RandomSolver;
import org.vl.shuffler.BaseRotation;

public class App {
    public static void main(String[] args) {
        final int size = 3, shuffle_times = 1;

        System.out.println("*****Initialize*****");
        RubiksCube cube = new RubiksCube(size);
        cube.print();

        System.out.printf("*****Shuffling <%s> times*****\n", shuffle_times);
        BaseRotation shuffler = new RandomShuffler(shuffle_times);
        shuffler.rotate(cube);

        System.out.println("*****Solving*****");
        BaseRotation solver = new RandomSolver();
        int times = solver.rotate(cube);
        System.out.printf("*****Solved after <%s> rotations!*****\n", times);
    }
}
