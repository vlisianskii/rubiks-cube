package org.vl.cube;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.vl.cube.SideIterator.getSides;

public class SideIteratorTest {
    @Test
    public void test_side_iterator_from_top() {
        // arrange
        Side side = Side.TOP;
        // act & assert
        assertEquals(List.of(Side.BACK, Side.BOTTOM, Side.MAIN), getSides(side, Direction.UP));
        assertEquals(List.of(Side.LEFT, Side.BOTTOM, Side.RIGHT), getSides(side, Direction.LEFT));
        assertEquals(List.of(Side.RIGHT, Side.BOTTOM, Side.LEFT), getSides(side, Direction.RIGHT));
        assertEquals(List.of(Side.MAIN, Side.BOTTOM, Side.BACK), getSides(side, Direction.DOWN));
    }

    @Test
    public void test_side_iterator_from_front() {
        // arrange
        Side side = Side.MAIN;
        // act & assert
        assertEquals(List.of(Side.TOP, Side.BACK, Side.BOTTOM), getSides(side, Direction.UP));
        assertEquals(List.of(Side.LEFT, Side.BACK, Side.RIGHT), getSides(side, Direction.LEFT));
        assertEquals(List.of(Side.RIGHT, Side.BACK, Side.LEFT), getSides(side, Direction.RIGHT));
        assertEquals(List.of(Side.BOTTOM, Side.BACK, Side.TOP), getSides(side, Direction.DOWN));
    }

    @Test
    public void test_side_iterator_from_left() {
        // arrange
        Side side = Side.LEFT;
        // act & assert
        assertEquals(List.of(Side.TOP, Side.RIGHT, Side.BOTTOM), getSides(side, Direction.UP));
        assertEquals(List.of(Side.BACK, Side.RIGHT, Side.MAIN), getSides(side, Direction.LEFT));
        assertEquals(List.of(Side.MAIN, Side.RIGHT, Side.BACK), getSides(side, Direction.RIGHT));
        assertEquals(List.of(Side.BOTTOM, Side.RIGHT, Side.TOP), getSides(side, Direction.DOWN));
    }

    @Test
    public void test_side_iterator_from_right() {
        // arrange
        Side side = Side.RIGHT;
        // act & assert
        assertEquals(List.of(Side.TOP, Side.LEFT, Side.BOTTOM), getSides(side, Direction.UP));
        assertEquals(List.of(Side.MAIN, Side.LEFT, Side.BACK), getSides(side, Direction.LEFT));
        assertEquals(List.of(Side.BACK, Side.LEFT, Side.MAIN), getSides(side, Direction.RIGHT));
        assertEquals(List.of(Side.BOTTOM, Side.LEFT, Side.TOP), getSides(side, Direction.DOWN));
    }

    @Test
    public void test_side_iterator_from_back() {
        // arrange
        Side side = Side.BACK;
        // act & assert
        assertEquals(List.of(Side.BOTTOM, Side.MAIN, Side.TOP), getSides(side, Direction.UP));
        assertEquals(List.of(Side.RIGHT, Side.MAIN, Side.LEFT), getSides(side, Direction.LEFT));
        assertEquals(List.of(Side.LEFT, Side.MAIN, Side.RIGHT), getSides(side, Direction.RIGHT));
        assertEquals(List.of(Side.TOP, Side.MAIN, Side.BOTTOM), getSides(side, Direction.DOWN));
    }

    @Test
    public void test_side_iterator_from_bottom() {
        // arrange
        Side side = Side.BOTTOM;
        // act & assert
        assertEquals(List.of(Side.MAIN, Side.TOP, Side.BACK), getSides(side, Direction.UP));
        assertEquals(List.of(Side.LEFT, Side.TOP, Side.RIGHT), getSides(side, Direction.LEFT));
        assertEquals(List.of(Side.RIGHT, Side.TOP, Side.LEFT), getSides(side, Direction.RIGHT));
        assertEquals(List.of(Side.BACK, Side.TOP, Side.MAIN), getSides(side, Direction.DOWN));
    }
}
