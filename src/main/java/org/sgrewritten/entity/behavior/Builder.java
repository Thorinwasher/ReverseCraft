package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;

public class Builder implements Behavior {
    public static Builder from(JsonObject jsonObject, NamespaceID namespaceID) {
        return new Builder();
    }

    @Override
    public NamespaceID key() {
        return null;
    }

    @Override
    public void doTick(BaseEntity baseEntity) {

    }

    @Override
    public Priority getPriority(BaseEntity baseEntity) {
        return Priority.NONE;
    }
}
