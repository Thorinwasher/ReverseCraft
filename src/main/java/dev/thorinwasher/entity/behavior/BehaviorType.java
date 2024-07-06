package dev.thorinwasher.entity.behavior;

import com.google.gson.JsonObject;
import dev.thorinwasher.Registry;
import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.namespace.Keyed;
import dev.thorinwasher.namespace.ReversedNamespace;

import java.util.function.BiFunction;

public class BehaviorType<T extends Behavior> implements BiFunction<JsonObject, NamespaceID, T>, Keyed {

    public static final Registry<BehaviorType<?>> BEHAVIOR_TYPES = new Registry<>(ReversedNamespace.fromKey("entity/behavior_type"));

    public static final BehaviorType<Breeding> BREEDING = register(Breeding::from, ReversedNamespace.fromKey("behavior_type/breeding"));
    public static final BehaviorType<Builder> BUILDER = register(Builder::from, ReversedNamespace.fromKey("behavior_type/builder"));
    public static final BehaviorType<Logistics> LOGISTICS = register(Logistics::from, ReversedNamespace.fromKey("behavior_type/logistics"));
    public static final BehaviorType<Researcher> RESEARCHER = register(Researcher::from, ReversedNamespace.fromKey("behavior_type/researcher"));
    public static final BehaviorType<Resource> RESOURCE = register(Resource::from, ReversedNamespace.fromKey("behavior_type/resource"));
    public static final BehaviorType<ResourceGatherer> RESOURCE_GATHERER = register(ResourceGatherer::from, ReversedNamespace.fromKey("behavior_type/resource_gatherer"));
    public static final BehaviorType<SelfPreservation> SELF_PRESERVATION = register(SelfPreservation::from, ReversedNamespace.fromKey("behavior_type/self_preservation"));
    public static final BehaviorType<Sleeper> SLEEP = register(Sleeper::from, ReversedNamespace.fromKey("behavior_type/sleeper"));
    public static final BehaviorType<Upgradeable> UPGRADEABLE = register(Upgradeable::from, ReversedNamespace.fromKey("behavior_type/upgradeable"));

    private final BiFunction<JsonObject, NamespaceID, T> constructor;
    private final NamespaceID key;

    BehaviorType(BiFunction<JsonObject, NamespaceID, T> constructor, NamespaceID key) {
        this.constructor = constructor;
        this.key = key;
    }

    @Override
    public T apply(JsonObject jsonObject, NamespaceID namespaceID) {
        return constructor.apply(jsonObject, namespaceID);
    }

    public NamespaceID key() {
        return key;
    }

    public static <K extends Behavior> BehaviorType<K> register(BiFunction<JsonObject, NamespaceID, K> constructor, NamespaceID key) {
        BehaviorType<K> behaviorType = new BehaviorType<>(constructor, key);
        BEHAVIOR_TYPES.put(key, behaviorType);
        return behaviorType;
    }
}
