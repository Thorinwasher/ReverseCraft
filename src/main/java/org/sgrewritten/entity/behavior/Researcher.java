package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;

public class Researcher implements Behavior {
    public static Researcher from(JsonObject jsonObject, NamespaceID namespaceID) {
        return new Researcher();
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
