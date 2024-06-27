package org.sgrewritten.encoding.decoders;

import com.google.gson.JsonObject;
import org.sgrewritten.Registry;
import org.sgrewritten.entity.attack.Attack;
import org.sgrewritten.entity.attack.AttackType;
import org.sgrewritten.namespace.ReversedNamespace;
import org.sgrewritten.util.JsonUtil;

public class AttackDecoder implements Decoder<Attack> {
    @Override
    public Attack parse(JsonObject jsonObject) {
        AttackType<?> attackType = Registry.ATTACK_TYPES.get(ReversedNamespace.fromKey(jsonObject.get("type").getAsString()));
        JsonObject data = JsonUtil.getObjectOrEmpty(jsonObject, "data");
        return attackType.apply(data, ReversedNamespace.fromKey(jsonObject.get("key").getAsString()));
    }
}
