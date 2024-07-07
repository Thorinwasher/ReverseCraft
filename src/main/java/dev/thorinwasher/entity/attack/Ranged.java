package dev.thorinwasher.entity.attack;

import com.google.gson.JsonObject;
import net.minestom.server.item.Material;
import net.minestom.server.utils.NamespaceID;

public class Ranged implements Attack {
    private final NamespaceID key;
    private final Material material;

    public Ranged(Material material, NamespaceID key) {
        this.key = key;
        this.material = material;
    }

    public static Ranged from(JsonObject jsonObject, NamespaceID key) {
        Material material = Material.fromNamespaceId(jsonObject.get("item").getAsString());
        return new Ranged(material, key);
    }

    @Override
    public NamespaceID key() {
        return key;
    }
}
