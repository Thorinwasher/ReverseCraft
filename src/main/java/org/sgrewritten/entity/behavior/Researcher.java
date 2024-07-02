package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.goal.Goal;

public class Researcher implements Behavior {
    private final NamespaceID key;

    public Researcher(NamespaceID key) {
        this.key = key;
    }

    public static Researcher from(JsonObject jsonObject, NamespaceID key) {
        return new Researcher(key);
    }

    @Override
    public Priority getPriority(BaseEntity baseEntity) {
        return Priority.NONE;
    }

    @Override
    public Goal getGoal(BaseEntity baseEntity) {
        return null;
    }

    @Override
    public NamespaceID key() {
        return key;
    }
}
