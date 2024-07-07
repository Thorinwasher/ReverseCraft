package dev.thorinwasher.entity.goal;

import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.entity.behavior.Breeding;
import dev.thorinwasher.namespace.ReversedNamespace;

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
