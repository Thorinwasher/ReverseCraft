package org.sgrewritten.entity.goal.group;

import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.goal.LookAround;
import org.sgrewritten.entity.goal.Rest;
import org.sgrewritten.entity.goal.StrollAroundArea;
import org.sgrewritten.namespace.ReversedNamespace;
import org.sgrewritten.util.ProbabilityHolder;

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
