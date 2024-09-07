package org.vl.utils;

import java.util.EnumSet;
import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static <T extends Enum<T>> int randomOrdinalOfEnum(Class<T> type) {
        return RANDOM.nextInt(EnumSet.allOf(type).size());
    }

    public static int randomNumberBetween(int min, int max) {
        return RANDOM.nextInt((max - min) + min);
    }
}
