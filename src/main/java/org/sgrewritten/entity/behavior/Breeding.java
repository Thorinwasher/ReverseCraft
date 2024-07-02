package org.sgrewritten.entity.behavior;

import com.google.gson.JsonObject;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Priority;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.goal.Breed;
import org.sgrewritten.entity.goal.Goal;

public class Breeding implements Behavior {

    private final NamespaceID key;

    private Breeding(NamespaceID key) {
        this.key = key;
    }

    public static Breeding from(JsonObject jsonObject, NamespaceID key) {
        return new Breeding(key);
    }

    @Override
    public NamespaceID key() {
        return key;
    }

    @Override
    public Priority getPriority(BaseEntity baseEntity) {
        return Priority.NONE;
    }

    @Override
    public Goal getGoal(BaseEntity baseEntity) {
        return new Breed(this);
    }
}
