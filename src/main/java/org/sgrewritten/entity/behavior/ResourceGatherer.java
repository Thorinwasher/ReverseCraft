package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.goal.Goal;

public class ResourceGatherer implements Behavior {


    private final NamespaceID key;

    public ResourceGatherer(NamespaceID key) {
        this.key = key;
    }

    public static ResourceGatherer from(JsonObject jsonObject, NamespaceID key) {
        return new ResourceGatherer(key);
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
