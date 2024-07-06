package dev.thorinwasher.util;

import dev.thorinwasher.entity.goal.Goal;
import net.minestom.server.coordinate.Point;
import dev.thorinwasher.entity.behavior.Behavior;

public class Key<T> {
    public static final Key<Point> HOME_POINT = new Key<>();
    public static final Key<Goal> CURRENT_GOAL = new Key<>();
    public static final Key<Behavior> CURRENT_BEHAVIOR = new Key<>();
}
