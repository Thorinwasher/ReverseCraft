package org.sgrewritten.entity.goal.group;

import org.sgrewritten.entity.goal.Goal;
import org.sgrewritten.util.ProbabilityHolder;

import java.util.List;

public abstract class GoalGroup implements Goal {

    private final Goal goal;

    public GoalGroup(List<ProbabilityHolder<Goal>> goals) {
        this.goal = ProbabilityHolder.chooseItem(goals);
    }

    @Override
    public void tick() {
        goal.tick();
    }

    @Override
    public boolean isCompleted() {
        return goal.isCompleted();
    }
}
