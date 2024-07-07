package dev.thorinwasher.entity.behavior;

import com.google.gson.JsonObject;
import dev.thorinwasher.Priority;
import dev.thorinwasher.entity.BaseEntity;
import dev.thorinwasher.entity.goal.Goal;
import net.minestom.server.utils.NamespaceID;

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
