package org.sgrewritten.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonUtil {

    public static JsonObject getObjectOrEmpty(JsonObject jsonObject, String key) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsJsonObject();
        } else {
            return new JsonObject();
        }
    }

    public static JsonArray getArrayOrEmpty(JsonObject jsonObject, String key) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsJsonArray();
        } else {
            return new JsonArray();
        }
    }
}
