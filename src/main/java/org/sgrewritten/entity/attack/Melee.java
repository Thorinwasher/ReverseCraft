package org.sgrewritten.entity.attack;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;

public class Melee implements Attack {
    private final int damage;
    private final int delay;
    private final NamespaceID key;

    public Melee(int damage, int delay, NamespaceID key) {
        this.damage = damage;
        this.delay = delay;
        this.key = key;
    }

    public static Melee from(JsonObject jsonObject, NamespaceID key) {
        int delay = jsonObject.get("delay").getAsInt();
        int damage = jsonObject.get("damage").getAsInt();
        return new Melee(damage, delay, key);
    }

    @Override
    public NamespaceID key() {
        return key;
    }
}
