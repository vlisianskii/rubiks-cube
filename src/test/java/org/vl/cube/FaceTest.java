package org.vl.cube;

import org.junit.Test;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static org.junit.Assert.*;

public class FaceTest {
    @Test
    public void test_face_get_initial_values() {
        // arrange
        int size = 2;
        Color color = Color.B;
        // act
        Face face = new Face(size, color);
        // assert
        Color[] expected = new Color[]{color, color};
        range(0, size).boxed()
                .forEach(x -> stream(Direction.values())
                        .forEach(direction -> assertArrayEquals(expected, face.getValues(x, direction))));
    }

    @Test
    public void test_face_set_vertical_values() {
        // arrange
        int size = 2;
        Color color = Color.B;
        Color[] newValues = new Color[]{Color.G, Color.O};
        Face face = new Face(size, color);
        // act
        face.setValues(0, Direction.UP, newValues);
        // assert
        assertArrayEquals(newValues, face.getValues(0, Direction.UP));
        assertArrayEquals(new Color[]{Color.G, color}, face.getValues(0, Direction.LEFT));
        assertArrayEquals(new Color[]{Color.G, color}, face.getValues(0, Direction.RIGHT));
        assertArrayEquals(newValues, face.getValues(0, Direction.DOWN));
        assertArrayEquals(new Color[]{color, color}, face.getValues(1, Direction.UP));
        assertArrayEquals(new Color[]{Color.O, color}, face.getValues(1, Direction.LEFT));
        assertArrayEquals(new Color[]{Color.O, color}, face.getValues(1, Direction.RIGHT));
        assertArrayEquals(new Color[]{color, color}, face.getValues(1, Direction.DOWN));
    }

    @Test
    public void test_face_is_solved() {
        // arrange
        int size = 2;
        Color color = Color.B;
        Face face = new Face(size, color);
        // act & assert
        assertTrue(face.isSolved());

        face.setValues(0, Direction.UP, new Color[]{Color.W, Color.R});
        assertFalse(face.isSolved());

        face.setValues(0, Direction.DOWN, new Color[]{color, color});
        assertTrue(face.isSolved());
    }

    @Test
    public void test_face_get_string() {
        // arrange
        int size = 3;
        Color color = Color.B;
        Face face = new Face(size, color);
        // act & assert
        assertArrayEquals(new String[]{"[B, B, B]", "[B, B, B]", "[B, B, B]"}, face.getString());

        face.setValues(1, Direction.LEFT, new Color[]{Color.W, Color.R, Color.O});
        assertArrayEquals(new String[]{"[B, B, B]", "[W, R, O]", "[B, B, B]"}, face.getString());
    }

    @Test
    public void test_face_to_string() {
        // arrange
        int size = 3;
        Color color = Color.B;
        Face face = new Face(size, color);
        // act & assert
        assertEquals("""
                [B, B, B]
                [B, B, B]
                [B, B, B]""", face.toString());

        face.setValues(2, Direction.RIGHT, new Color[]{Color.W, Color.R, Color.O});
        assertEquals("""
                [B, B, B]
                [B, B, B]
                [W, R, O]""", face.toString());
    }
}
