package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;

public class ResourceGatherer implements Behavior {


    public static ResourceGatherer from(JsonObject jsonObject, NamespaceID namespaceID) {
        return new ResourceGatherer();
    }

    @Override
    public void doTick(BaseEntity baseEntity) {

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
