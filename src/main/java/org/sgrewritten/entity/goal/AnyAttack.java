package org.sgrewritten.entity.goal;

import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.behavior.Behavior;
import org.sgrewritten.namespace.ReversedNamespace;

public class AnyAttack implements Goal {

    @Override
    public void tick() {

    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public NamespaceID key() {
        return ReversedNamespace.fromKey("goal/any_attack");
    }
}