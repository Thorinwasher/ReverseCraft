package dev.thorinwasher.entity.behavior;

import dev.thorinwasher.util.Key;
import dev.thorinwasher.util.MetaData;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BehaviorData implements MetaData {

    public Map<Key<?>, Object> data = new HashMap<>();

    @Override
    public <T> Optional<T> get(Key<T> key) {
        return Optional.ofNullable((T) data.get(key));
    }

    @Override
    public <T> void set(Key<T> key, T value){
        data.put(key, value);
    }

    @Override
    public <T> Optional<T> remove(Key<T> key){
        return Optional.ofNullable((T) data.remove(key));
    }
}
