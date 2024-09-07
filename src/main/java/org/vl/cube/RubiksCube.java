package org.vl.cube;

import lombok.Getter;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static org.vl.cube.SideIterator.getSides;

@Getter
public class RubiksCube {
    private final int size;
    private final Map<Side, Face> faces;

    public RubiksCube(int size) {
        this.size = size;
        this.faces = Map.of(
                Side.TOP, new Face(size, Color.W),
                Side.MAIN, new Face(size, Color.R),
                Side.LEFT, new Face(size, Color.G),
                Side.RIGHT, new Face(size, Color.B),
                Side.BOTTOM, new Face(size, Color.Y),
                Side.BACK, new Face(size, Color.O)
        );
    }

    public void rotate(Side side, int x, Direction direction) {
        System.out.printf("<%s::%s::%s>\n", side, x, direction);

        Face face = faces.get(side);
        Color[] colors = face.getValues(x, direction);
        for (Side nextSide : getSides(side, direction)) {
            Face nextFace = faces.get(nextSide);
            Color[] nextColors = nextFace.getValues(x, direction);
            nextFace.setValues(x, direction, colors);
            colors = nextColors;
        }
        face.setValues(x, direction, colors);

        print();
    }

    public void print() {
        printRows(getEmptyFace(), faces.get(Side.TOP).getString());
        printRows(faces.get(Side.LEFT).getString(), faces.get(Side.MAIN).getString(), faces.get(Side.RIGHT).getString(), faces.get(Side.BACK).getString());
        printRows(getEmptyFace(), faces.get(Side.BOTTOM).getString());
    }

    private void printRows(String[]... sides) {
        stream(sides)
                .reduce((o1, o2) ->
                        range(0, o1.length).boxed()
                                .map(i -> o1[i].concat(" ").concat(o2[i]))
                                .toArray(String[]::new)
                )
                .ifPresent(o -> stream(o).forEach(System.out::println));

    }

    private String[] getEmptyFace(){
        return range(0, size).boxed().map(i -> " ".repeat(size * size)).toArray(String[]::new);
    }

    public boolean isSolved() {
        for (Side side: faces.keySet()) {
            if (!faces.get(side).isSolved()) {
                return false;
            }
        }
        return true;
    }
}
