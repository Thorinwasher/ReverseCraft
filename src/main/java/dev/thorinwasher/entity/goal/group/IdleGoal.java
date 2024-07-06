package dev.thorinwasher.entity.goal.group;

import dev.thorinwasher.entity.BaseEntity;
import dev.thorinwasher.entity.goal.LookAround;
import dev.thorinwasher.entity.goal.Rest;
import dev.thorinwasher.entity.goal.StrollAroundArea;
import dev.thorinwasher.util.ProbabilityHolder;
import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.namespace.ReversedNamespace;

import java.util.List;
import java.util.Random;

public class IdleGoal extends GoalGroup {

    private static final Random RANDOM = new Random();

    public IdleGoal(int strollRadius, BaseEntity baseEntity) {
        super(List.of(new ProbabilityHolder<>(new StrollAroundArea(strollRadius, baseEntity), 0.2),
                new ProbabilityHolder<>(new Rest(RANDOM.nextInt(10, 20)), 0.4),
                new ProbabilityHolder<>(new LookAround(baseEntity), 0.4))
        );
    }

    @Override
    public NamespaceID key() {
        return ReversedNamespace.fromKey("goal/idle");
    }
}
