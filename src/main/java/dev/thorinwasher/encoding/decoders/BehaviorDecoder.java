package dev.thorinwasher.encoding.decoders;

import com.google.gson.JsonObject;
import dev.thorinwasher.Registry;
import dev.thorinwasher.entity.behavior.Behavior;
import dev.thorinwasher.entity.behavior.BehaviorType;
import dev.thorinwasher.util.JsonUtil;
import dev.thorinwasher.namespace.ReversedNamespace;

public class BehaviorDecoder implements Decoder<Behavior> {
    @Override
    public Behavior parse(JsonObject jsonObject) {
        BehaviorType<?> behaviorType = Registry.BEHAVIOR_TYPES.get(ReversedNamespace.fromKey(jsonObject.get("type").getAsString()));
        JsonObject data = JsonUtil.getObjectOrEmpty(jsonObject, "data");
        return behaviorType.apply(data, ReversedNamespace.fromKey(jsonObject.get("key").getAsString()));
    }
}
