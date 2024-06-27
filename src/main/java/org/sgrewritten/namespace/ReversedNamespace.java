package org.sgrewritten.namespace;

import net.minestom.server.utils.NamespaceID;

public class ReversedNamespace {

    private static final String NAMESPACE = "reversed_minecraft";

    public static NamespaceID fromKey(String key){
        return NamespaceID.from(NAMESPACE, key);
    }
}
