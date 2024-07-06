package dev.thorinwasher.entity.behavior;

import com.google.gson.JsonObject;
import dev.thorinwasher.Priority;
import dev.thorinwasher.entity.BaseEntity;
import dev.thorinwasher.entity.goal.Goal;
import dev.thorinwasher.entity.goal.group.IdleGoal;
import net.minestom.server.utils.NamespaceID;

public class Resource implements Behavior {
    private final NamespaceID key;
    private final int strollRadius;

    public Resource(NamespaceID key, int strollRadius) {
        this.key = key;
        this.strollRadius = strollRadius;
    }

    public static Resource from(JsonObject jsonObject, NamespaceID key) {
        int strollRadius = jsonObject.get("radius").getAsInt();
        return new Resource(key, strollRadius);
    }

    @Override
    public Priority getPriority(BaseEntity baseEntity) {
        return Priority.LOW;
    }

    @Override
    public Goal getGoal(BaseEntity baseEntity) {
        return new IdleGoal(strollRadius, baseEntity);
    }

    @Override
    public NamespaceID key() {
        return key;
    }
}
