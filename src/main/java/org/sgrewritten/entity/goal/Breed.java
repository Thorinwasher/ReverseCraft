package org.sgrewritten.entity.goal;

import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.behavior.Behavior;
import org.sgrewritten.entity.behavior.Breeding;
import org.sgrewritten.namespace.ReversedNamespace;

public class Breed implements Goal {

    private final Breeding behavior;

    public Breed(Breeding behavior) {
        this.behavior = behavior;
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public NamespaceID key() {
        return ReversedNamespace.fromKey("goal/breed");
    }
}
