package org.sgrewritten.entity.behavior;

import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.goal.Goal;
import org.sgrewritten.namespace.Keyed;
import org.sgrewritten.world.UpdatablePosition;

public interface Behavior extends Keyed {

    Priority getPriority(BaseEntity baseEntity);

    Goal getGoal(BaseEntity baseEntity);
}
