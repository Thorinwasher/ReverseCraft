package dev.thorinwasher.entity.goal;

import dev.thorinwasher.namespace.Keyed;

public interface Goal extends Keyed {

    void tick();

    boolean isCompleted();
}
