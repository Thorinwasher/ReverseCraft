package dev.thorinwasher.entity.goal;

import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.namespace.ReversedNamespace;

public class AttackMelee implements Goal {

    @Override
    public void tick() {

    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public NamespaceID key() {
        return ReversedNamespace.fromKey("goal/attack_melee");
    }
}