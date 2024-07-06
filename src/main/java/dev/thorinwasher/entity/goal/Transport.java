package dev.thorinwasher.entity.goal;

import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.namespace.ReversedNamespace;

public class Transport implements Goal {


    @Override
    public void tick() {

    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public NamespaceID key() {
        return ReversedNamespace.fromKey("goal/transport");
    }
}
