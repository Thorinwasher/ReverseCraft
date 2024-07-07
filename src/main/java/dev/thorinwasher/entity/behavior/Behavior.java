package dev.thorinwasher.entity.behavior;

import dev.thorinwasher.Priority;
import dev.thorinwasher.entity.BaseEntity;
import dev.thorinwasher.entity.goal.Goal;
import dev.thorinwasher.namespace.Keyed;

public interface Behavior extends Keyed {

    Priority getPriority(BaseEntity baseEntity);

    Goal getGoal(BaseEntity baseEntity);
}
