package org.sgrewritten.util;

import java.util.Optional;

public interface MetaData {

    <T> Optional<T> get(Key<T> key);

    <T> void set(Key<T> key, T value);

    <T> Optional<T> remove(Key<T> key);
}
