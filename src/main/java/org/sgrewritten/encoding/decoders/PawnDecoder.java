package org.sgrewritten.encoding.decoders;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minestom.server.entity.EntityType;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.Registry;
import org.sgrewritten.entity.PawnType;
import org.sgrewritten.entity.attack.Attack;
import org.sgrewritten.entity.behavior.Behavior;
import org.sgrewritten.namespace.ReversedNamespace;
import org.sgrewritten.util.JsonUtil;

import java.util.List;

public class PawnDecoder implements Decoder<PawnType> {
    @Override
    public PawnType parse(JsonObject jsonObject) {
        System.out.println(jsonObject);
        JsonArray jsonAttacks = JsonUtil.getArrayOrEmpty(jsonObject, "attacks");
        List<Attack> attacks = jsonAttacks.asList().stream()
                .map(JsonElement::getAsString)
                .map(ReversedNamespace::fromKey)
                .map(Registry.ATTACKS::get).toList();

        JsonArray jsonBehaviors = JsonUtil.getArrayOrEmpty(jsonObject, "behaviors");
        List<Behavior> behaviors = jsonBehaviors.asList().stream()
                .map(JsonElement::getAsString)
                .map(ReversedNamespace::fromKey)
                .map(Registry.BEHAVIORS::get).toList();
        NamespaceID key = ReversedNamespace.fromKey(jsonObject.get("key").getAsString());
        EntityType entityType = EntityType.fromNamespaceId(jsonObject.get("entity").getAsString());
        float maxHealth = jsonObject.get("max_health").getAsFloat();
        return new PawnType(behaviors, attacks, key, entityType, jsonObject.get("name").getAsString(), maxHealth);
    }
}
