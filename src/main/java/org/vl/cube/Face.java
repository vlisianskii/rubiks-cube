package org.vl.cube;

import java.util.Arrays;

import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.fill;
import static java.util.stream.IntStream.range;

public class Face {
    private final Color[][] values;

    public Face(int size, Color color) {
        this(generateNewSide(size, color));
    }

    public Face(Color[][] values) {
        this.values = values;
    }

    public Color[] getValues(int x, Direction direction) {
        return switch (direction) {
            case UP, DOWN -> getCol(x);
            case LEFT, RIGHT -> getRow(x);
        };
    }

    public void setValues(int x, Direction direction, Color[] newValues) {
        switch (direction) {
            case UP, DOWN -> setCol(x, newValues);
            case LEFT, RIGHT -> setRow(x, newValues);
        }
    }

    private void setRow(int row, Color[] newValues) {
        arraycopy(newValues, 0, values[row], 0, values[row].length);
    }

    private void setCol(int col, Color[] newValues) {
        range(0, values.length).forEach(i -> values[i][col] = newValues[i]);
    }

    private Color[] getRow(int row) {
        return copyOf(values[row], values.length);
    }

    private Color[] getCol(int col) {
        Color[] result = new Color[values.length];
        for (int row = 0; row < values.length; row++) {
            result[row] = values[row][col];
        }
        return result;
    }

    public boolean isSolved() {
        Color color = values[0][0];
        for (Color[] rows : values) {
            for (Color cell : rows) {
                if (!color.equals(cell)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String[] getString() {
        return range(0, values.length).boxed()
                .map(i -> Arrays.toString(values[i]))
                .toArray(String[]::new);
    }

    public String toString() {
        return String.join("\n", getString());
    }

    private static Color[][] generateNewSide(int size, Color color) {
        Color[][] grid = new Color[size][size];
        for (Color[] row : grid) {
            fill(row, color);
        }
        return grid;
    }
}
