package org.vl;

import org.vl.cube.RubiksCube;
import org.vl.shuffle.ConditionalShuffle;
import org.vl.shuffle.Shuffler;
import org.vl.shuffle.Solver;

public class App {
    public static void main(String[] args) {
        final int size = 3, shuffle_times = 1;

        System.out.println("*****Initialize*****");
        RubiksCube cube = new RubiksCube(size);
        cube.print();

        System.out.printf("*****Shuffling <%s> times*****\n", shuffle_times);
        ConditionalShuffle shuffle = new Shuffler(shuffle_times);
        shuffle.shuffle(cube);

        System.out.println("*****Solving*****");
        ConditionalShuffle solver = new Solver();
        solver.shuffle(cube);
    }
}
