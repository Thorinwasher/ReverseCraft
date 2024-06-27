package org.sgrewritten;

import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.encoding.decoders.Decoders;
import org.sgrewritten.encoding.decoders.JsonRegistryDecoder;
import org.sgrewritten.entity.PawnType;
import org.sgrewritten.entity.attack.Attack;
import org.sgrewritten.entity.attack.AttackType;
import org.sgrewritten.entity.behavior.Behavior;
import org.sgrewritten.entity.behavior.BehaviorType;
import org.sgrewritten.namespace.Keyed;

import java.util.HashMap;

public class Registry<T extends Keyed> extends HashMap<NamespaceID, T> implements Keyed {

    public static final Registry<AttackType<?>> ATTACK_TYPES = AttackType.ATTACK_TYPES;
    public static final Registry<Attack> ATTACKS = JsonRegistryDecoder.parse("/entity/attack", Decoders.ATTACK);
    public static final Registry<BehaviorType<?>> BEHAVIOR_TYPES = BehaviorType.BEHAVIOR_TYPES;
    public static final Registry<Behavior> BEHAVIORS = JsonRegistryDecoder.parse("/entity/behavior", Decoders.BEHAVIOR);
    public static final Registry<PawnType> PAWN_TYPES = JsonRegistryDecoder.parse("/entity/pawn", Decoders.PAWN);

    private final NamespaceID key;

    public Registry(NamespaceID key) {
        super();
        this.key = key;
    }

    @Override
    public NamespaceID key() {
        return key;
    }
}
