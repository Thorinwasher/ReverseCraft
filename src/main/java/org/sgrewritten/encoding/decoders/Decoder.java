package org.sgrewritten.encoding.decoders;

import com.google.gson.JsonObject;
import org.sgrewritten.namespace.Keyed;

public interface Decoder<T extends Keyed> {

    T parse(JsonObject jsonObject);
}
