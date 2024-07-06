package dev.thorinwasher.entity.goal;

import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.namespace.ReversedNamespace;

public class Rest implements Goal {
    private int ticksLeft;

    public Rest(int ticks) {
        this.ticksLeft = ticks;
    }

    @Override
    public void tick() {
        ticksLeft--;
    }

    @Override
    public boolean isCompleted() {
        return ticksLeft < 0;
    }

    @Override
    public NamespaceID key() {
        return ReversedNamespace.fromKey("goal/rest");
    }
}
