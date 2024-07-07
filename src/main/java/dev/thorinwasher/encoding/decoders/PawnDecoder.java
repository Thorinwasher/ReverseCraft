package dev.thorinwasher.encoding.decoders;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.thorinwasher.Registry;
import dev.thorinwasher.entity.PawnType;
import dev.thorinwasher.entity.attack.Attack;
import dev.thorinwasher.entity.behavior.Behavior;
import dev.thorinwasher.util.JsonUtil;
import net.minestom.server.entity.EntityType;
import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.namespace.ReversedNamespace;

import java.util.List;

public class PawnDecoder implements Decoder<PawnType> {
    @Override
    public PawnType parse(JsonObject jsonObject) {
        System.out.println(jsonObject);
        JsonArray jsonAttacks = JsonUtil.getArrayOrEmpty(jsonObject, "attacks");
        List<Attack> attacks = jsonAttacks.asList().stream()
                .map(JsonElement::getAsString)
                .map(ReversedNamespace::fromKey)
                .filter(key -> {
                    if (Registry.ATTACKS.containsKey(key)) {
                        return true;
                    }
                    System.out.println("Invalid attack key: " + key);
                    return false;
                })
                .map(Registry.ATTACKS::get).toList();

        JsonArray jsonBehaviors = JsonUtil.getArrayOrEmpty(jsonObject, "behaviors");
        List<Behavior> behaviors = jsonBehaviors.asList().stream()
                .map(JsonElement::getAsString)
                .map(ReversedNamespace::fromKey)
                .filter(key -> {
                    if (Registry.BEHAVIORS.containsKey(key)) {
                        return true;
                    }
                    System.out.println("Invalid behavior key: " + key);
                    return false;
                })
                .map(Registry.BEHAVIORS::get).toList();
        NamespaceID key = ReversedNamespace.fromKey(jsonObject.get("key").getAsString());
        EntityType entityType = EntityType.fromNamespaceId(jsonObject.get("entity").getAsString());
        float maxHealth = jsonObject.get("max_health").getAsFloat();
        NamespaceID movementBehaviorKey = ReversedNamespace.fromKey(jsonObject.get("movement").getAsString());
        return new PawnType(behaviors, attacks, key, entityType, jsonObject.get("name").getAsString(), maxHealth, Registry.MOVEMENT_BEHAVIORS.get(movementBehaviorKey));
    }
}
