package org.sgrewritten.entity.goal;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.ai.EntityAIGroup;
import net.minestom.server.entity.ai.EntityAIGroupBuilder;
import net.minestom.server.entity.ai.goal.RandomLookAroundGoal;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.entity.BaseEntity;

import java.util.Random;

public class LookAround implements Goal {

    private final BaseEntity baseEntity;
    private final EntityAIGroup lookAroundGroup;
    private int time;

    public LookAround(BaseEntity baseEntity, int time, int chancePerTick) {
        this.baseEntity = baseEntity;
        this.time = time;
        this.lookAroundGroup = (new EntityAIGroupBuilder().addGoalSelector(new RandomLookAroundGoal(baseEntity, chancePerTick)).build());
        this.baseEntity.getAIGroups().add(lookAroundGroup);
    }

    @Override
    public void tick() {
        time--;
        if (time < 0) {
            this.baseEntity.getAIGroups().remove(lookAroundGroup);
        }
    }

    @Override
    public boolean isCompleted() {
        return time < 0;
    }

    @Override
    public NamespaceID key() {
        return ReversedNamespace.fromKey("goal/look_around");
    }


}
