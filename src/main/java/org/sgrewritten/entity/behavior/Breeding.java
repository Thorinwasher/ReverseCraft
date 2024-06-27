package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;

public class Breeding implements Behavior {

    public static Breeding from(JsonObject jsonObject, NamespaceID key) {
        return new Breeding();
    }

    @Override
    public NamespaceID key() {
        return null;
    }

    @Override
    public void doTick(BaseEntity baseEntity) {
        baseEntity.setVelocity(new Vec(0, 0, 0));
    }

    @Override
    public Priority getPriority(BaseEntity baseEntity) {
        return Priority.NONE;
    }
}
