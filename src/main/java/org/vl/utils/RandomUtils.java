package org.vl.utils;

import java.util.EnumSet;

public class RandomUtils {
    public static <T extends Enum<T>> int randomOrdinalOfEnum(Class<T> type) {
        return randomNumberBetween(minOrdinal(type), maxOrdinal(type));
    }

    public static int randomNumberBetween(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }

    private static <T extends Enum<T>> int minOrdinal(Class<T> type) {
        return EnumSet.allOf(type).stream().mapToInt(Enum::ordinal).min().orElse(0);
    }

    private static <T extends Enum<T>> int maxOrdinal(Class<T> type) {
        return EnumSet.allOf(type).stream().mapToInt(Enum::ordinal).max().orElse(0);
    }
}
