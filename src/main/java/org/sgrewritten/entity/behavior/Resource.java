package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.world.UpdatablePosition;

public class Resource implements Behavior {
    public static Resource from(JsonObject jsonObject, NamespaceID namespaceID) {
        return new Resource();
    }

    @Override
    public UpdatablePosition getDestination(BaseEntity baseEntity) {

        return null;
    }

    @Override
    public Priority getPriority(BaseEntity baseEntity) {
        return Priority.NONE;
    }

    @Override
    public NamespaceID key() {
        return null;
    }
}
