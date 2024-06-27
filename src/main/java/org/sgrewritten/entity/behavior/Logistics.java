package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;

public class Logistics implements Behavior {
    public static Logistics from(JsonObject jsonObject, NamespaceID key) {
        return new Logistics();
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
