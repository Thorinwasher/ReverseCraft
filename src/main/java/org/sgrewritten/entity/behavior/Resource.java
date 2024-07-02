package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.goal.*;
import org.sgrewritten.entity.goal.group.IdleGoal;

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
