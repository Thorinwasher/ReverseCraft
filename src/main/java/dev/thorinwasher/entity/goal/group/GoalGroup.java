package dev.thorinwasher.entity.goal.group;

import dev.thorinwasher.entity.goal.Goal;
import dev.thorinwasher.util.ProbabilityHolder;

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
