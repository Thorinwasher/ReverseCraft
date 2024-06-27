package org.sgrewritten.encoding.decoders;

import com.google.gson.JsonObject;
import org.sgrewritten.Registry;
import org.sgrewritten.entity.behavior.Behavior;
import org.sgrewritten.entity.behavior.BehaviorType;
import org.sgrewritten.namespace.ReversedNamespace;
import org.sgrewritten.util.JsonUtil;

public class BehaviorDecoder implements Decoder<Behavior> {
    @Override
    public Behavior parse(JsonObject jsonObject) {
        BehaviorType<?> behaviorType = Registry.BEHAVIOR_TYPES.get(ReversedNamespace.fromKey(jsonObject.get("type").getAsString()));
        JsonObject data = JsonUtil.getObjectOrEmpty(jsonObject, "data");
        System.out.println(jsonObject);
        return behaviorType.apply(data, ReversedNamespace.fromKey(jsonObject.get("type").getAsString()));
    }
}
