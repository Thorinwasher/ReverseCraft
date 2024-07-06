package dev.thorinwasher.encoding.decoders;

import com.google.gson.JsonObject;
import dev.thorinwasher.namespace.Keyed;

public interface Decoder<T extends Keyed> {

    T parse(JsonObject jsonObject);
}
