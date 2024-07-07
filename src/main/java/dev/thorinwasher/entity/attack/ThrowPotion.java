package dev.thorinwasher.entity.attack;

import com.google.gson.JsonObject;
import net.minestom.server.potion.PotionEffect;
import net.minestom.server.utils.NamespaceID;

public class ThrowPotion implements Attack {


    private final PotionEffect potionEffect;
    private final NamespaceID key;

    public ThrowPotion(PotionEffect potionEffect, NamespaceID key) {
        this.potionEffect = potionEffect;
        this.key = key;
    }

    public static ThrowPotion from(JsonObject jsonObject, NamespaceID key) {
        PotionEffect potionEffect = PotionEffect.fromNamespaceId(jsonObject.get("effect").getAsString());
        return new ThrowPotion(potionEffect, key);
    }

    @Override
    public NamespaceID key() {
        return key;
    }
}
