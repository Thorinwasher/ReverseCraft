package dev.thorinwasher.entity.behavior;

import com.google.gson.JsonObject;
import dev.thorinwasher.Priority;
import dev.thorinwasher.entity.BaseEntity;
import dev.thorinwasher.entity.goal.Goal;
import net.minestom.server.utils.NamespaceID;

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
