package dev.thorinwasher.encoding.decoders;

import com.google.gson.JsonObject;
import dev.thorinwasher.Registry;
import dev.thorinwasher.entity.attack.Attack;
import dev.thorinwasher.entity.attack.AttackType;
import dev.thorinwasher.util.JsonUtil;
import dev.thorinwasher.namespace.ReversedNamespace;

public class AttackDecoder implements Decoder<Attack> {
    @Override
    public Attack parse(JsonObject jsonObject) {
        AttackType<?> attackType = Registry.ATTACK_TYPES.get(ReversedNamespace.fromKey(jsonObject.get("type").getAsString()));
        JsonObject data = JsonUtil.getObjectOrEmpty(jsonObject, "data");
        return attackType.apply(data, ReversedNamespace.fromKey(jsonObject.get("key").getAsString()));
    }
}
