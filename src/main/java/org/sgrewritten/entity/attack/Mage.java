package org.sgrewritten.entity.attack;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;

import java.util.Locale;

public class Mage implements Attack {
    private final MagicType magicType;
    private final NamespaceID key;

    public static Mage from(JsonObject jsonObject, NamespaceID key) {
        MagicType magicType = MagicType.valueOf(jsonObject.get("magic_type").getAsString().toUpperCase(Locale.ROOT));
        return new Mage(magicType, key);
    }

    private Mage(MagicType magicType, NamespaceID key) {
        this.magicType = magicType;
        this.key = key;
    }

    @Override
    public NamespaceID key() {
        return key;
    }

    public enum MagicType {
        EXPLOSIVE
    }
}
