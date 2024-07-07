package dev.thorinwasher.entity;

import net.minestom.server.entity.EntityCreature;
import net.minestom.server.entity.attribute.Attribute;
import org.jetbrains.annotations.NotNull;
import dev.thorinwasher.Priority;
import dev.thorinwasher.entity.behavior.Behavior;
import dev.thorinwasher.entity.behavior.BehaviorData;
import dev.thorinwasher.entity.goal.Goal;
import dev.thorinwasher.util.Key;

import java.util.Optional;

public class BaseEntity extends EntityCreature {
    private PawnType pawnType;
    private final BehaviorData behaviorData = new BehaviorData();
    private float speed;

    public BaseEntity(@NotNull PawnType pawnType) {
        super(pawnType.entityType());

        setPawnType(pawnType);
    }

    public void setPawnType(PawnType pawnType) {
        this.pawnType = pawnType;
        setHealth(pawnType.maxHealth());
        setMovementBehavior(pawnType.movementBehavior());
    }

    public void setMovementBehavior(MovementBehavior movementBehavior){
        this.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(movementBehavior.walkSpeed());
        this.getAttribute(Attribute.GENERIC_WATER_MOVEMENT_EFFICIENCY).setBaseValue(movementBehavior.swimSpeed());
    }

    public float getMaxHealth() {
        return pawnType.maxHealth();
    }

    @Override
    public void tick(long time) {
        choseBehavior().ifPresent(behavior -> {
            Goal goal;
            if (!behaviorData.get(Key.CURRENT_BEHAVIOR).map(behavior::equals).orElse(false)) {
                goal = behavior.getGoal(this);
                behaviorData.set(Key.CURRENT_BEHAVIOR, behavior);
            } else {
                goal = behaviorData.get(Key.CURRENT_GOAL).orElse(behavior.getGoal(this));
            }
            behaviorData.set(Key.CURRENT_GOAL, goal);
            goal.tick();
            if (goal.isCompleted()) {
                behaviorData.remove(Key.CURRENT_GOAL);
            }
        });
        super.tick(time);
    }

    public BehaviorData getData() {
        return this.behaviorData;
    }

    private Optional<Behavior> choseBehavior() {
        Priority highestPriority = Priority.NONE;
        Behavior highestPriorityBehavior = null;

        for (Behavior behavior : pawnType.entityBehaviors()) {
            Priority priority = behavior.getPriority(this);
            if (priority.largerThan(highestPriority)) {
                highestPriority = priority;
                highestPriorityBehavior = behavior;
            }
        }
        return Optional.ofNullable(highestPriorityBehavior);
    }
}
