package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;

public class Upgradeable implements Behavior {
    public static Upgradeable from(JsonObject jsonObject, NamespaceID namespaceID) {
        return new Upgradeable();
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
