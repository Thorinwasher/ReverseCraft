package org.sgrewritten.util;

import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Random;

public class ProbabilityHolder<T> {

    private final double probability;
    private final T item;
    private final static Random RANDOM = new Random();

    public ProbabilityHolder(T item, double probability) {
        Preconditions.checkArgument(probability > 0, "Probability needs to be larger than 0");
        this.probability = probability;
        this.item = item;
    }

    public static <K> K chooseItem(List<ProbabilityHolder<K>> items) {
        double cumalitiveSum1 = 0;
        for (ProbabilityHolder<K> probabilityHolder : items) {
            cumalitiveSum1 += probabilityHolder.probability;
        }
        double chosenValue = RANDOM.nextDouble(0, cumalitiveSum1);
        double cumalitiveSum2 = 0;
        for (ProbabilityHolder<K> probabilityHolder : items) {
            cumalitiveSum2 += probabilityHolder.probability;
            if (chosenValue < cumalitiveSum2) {
                return probabilityHolder.item;
            }
        }
        throw new IllegalStateException("Invalid state; this is a bug");
    }

}
