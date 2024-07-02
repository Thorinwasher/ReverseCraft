package org.sgrewritten.util;

import net.minestom.server.coordinate.Point;
import org.sgrewritten.entity.behavior.Behavior;
import org.sgrewritten.entity.goal.Goal;

public class Key<T> {
    public static final Key<Point> HOME_POINT = new Key<>();
    public static final Key<Goal> CURRENT_GOAL = new Key<>();
    public static final Key<Behavior> CURRENT_BEHAVIOR = new Key<>();
}
