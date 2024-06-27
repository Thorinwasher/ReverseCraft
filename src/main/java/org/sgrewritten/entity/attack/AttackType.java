package org.sgrewritten.entity.attack;

import com.google.gson.JsonObject;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Registry;
import org.sgrewritten.namespace.Keyed;
import org.sgrewritten.namespace.ReversedNamespace;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class AttackType<T extends Attack> implements BiFunction<JsonObject, NamespaceID, T>, Keyed {

    public static final Registry<AttackType<?>> ATTACK_TYPES = new Registry<>(ReversedNamespace.fromKey("entity/attack_type"));

    public static final AttackType<Mage> MAGE = register(Mage::from, ReversedNamespace.fromKey("attack_type/magic"));
    public static final AttackType<Melee> MELEE = register(Melee::from, ReversedNamespace.fromKey("attack_type/melee"));
    public static final AttackType<ThrowPotion> POTION_THROWER = register(ThrowPotion::from, ReversedNamespace.fromKey("attack_type/throw_potion"));
    public static final AttackType<Ranged> RANGED = register(Ranged::from, ReversedNamespace.fromKey("attack_type/ranged"));

    private final BiFunction<JsonObject, NamespaceID, T> constructor;
    private final NamespaceID key;

    AttackType(BiFunction<JsonObject, NamespaceID, T> constructor, NamespaceID key) {
        this.constructor = constructor;
        this.key = key;
    }

    @Override
    public T apply(JsonObject jsonObject, NamespaceID namespaceID) {
        return constructor.apply(jsonObject, namespaceID);
    }

    @Override
    public NamespaceID key() {
        return key;
    }

    public static <K extends Attack> AttackType<K> register(BiFunction<JsonObject, NamespaceID, K> constructor, NamespaceID key) {
        AttackType<K> behaviorType = new AttackType<>(constructor, key);
        ATTACK_TYPES.put(key, behaviorType);
        return behaviorType;
    }
}
