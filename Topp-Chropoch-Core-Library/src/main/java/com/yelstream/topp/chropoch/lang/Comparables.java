package com.yelstream.topp.chropoch.lang;

import lombok.experimental.UtilityClass;

/**
 * Utility addressing instances of {@link Comparable}.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-03-19
 */
@UtilityClass
public class Comparables {
    /**
     * Determines the minimum of two values.
     * @param a First value.
     * @param b Second value.
     * @return Minimum value.
     * @param <T> Type of value.
     */
    public static <T extends Comparable<T>> T min(T a, T b) {
        return a.compareTo(b)<=0?a:b;
    }

    /**
     * Determines the maximum of two values.
     * @param a First value.
     * @param b Second value.
     * @return Maximum value.
     * @param <T> Type of value.
     */
    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b)>=0?a:b;
    }

    /**
     * Indicates, if two values are equal.
     * @param a First value.
     * @param b Second value.
     * @return Indicates, if values are equal.
     * @param <T> Type of value.
     */
    public static <T extends Comparable<T>> boolean equals(T a, T b) {
        return a.compareTo(b)==0;
    }
}
