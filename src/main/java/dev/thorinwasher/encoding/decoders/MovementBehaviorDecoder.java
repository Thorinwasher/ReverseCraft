package dev.thorinwasher.encoding.decoders;


import com.google.gson.JsonObject;
import dev.thorinwasher.entity.MovementBehavior;
import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.namespace.ReversedNamespace;

public class MovementBehaviorDecoder implements Decoder<MovementBehavior> {
    @Override
    public MovementBehavior parse(JsonObject jsonObject) {
        double walkSpeed = jsonObject.get("walking").getAsDouble()/20;
        double runSpeed = jsonObject.get("sprinting").getAsDouble()/20;
        double sneakSpeed = jsonObject.get("sneaking").getAsDouble()/20;
        double swimSpeed = jsonObject.get("swimming").getAsDouble()/20;
        NamespaceID key = ReversedNamespace.fromKey(jsonObject.get("key").getAsString());
        return new MovementBehavior(walkSpeed, runSpeed, sneakSpeed, swimSpeed, key);
    }
}
