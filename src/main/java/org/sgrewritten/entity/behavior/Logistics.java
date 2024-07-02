package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.goal.Goal;

public class Logistics implements Behavior {
    private final NamespaceID key;

    public Logistics(NamespaceID key) {
        this.key = key;
    }

    public static Logistics from(JsonObject jsonObject, NamespaceID key) {
        return new Logistics(key);
    }

    @Override
    public NamespaceID key() {
        return key;
    }

    @Override
    public Priority getPriority(BaseEntity baseEntity) {
        return Priority.NONE;
    }

    @Override
    public Goal getGoal(BaseEntity baseEntity) {
        return null;
    }
}
