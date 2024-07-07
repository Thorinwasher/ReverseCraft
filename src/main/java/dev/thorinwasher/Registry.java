package dev.thorinwasher;

import dev.thorinwasher.entity.MovementBehavior;
import dev.thorinwasher.entity.PawnType;
import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.encoding.decoders.Decoders;
import dev.thorinwasher.encoding.decoders.JsonRegistryDecoder;
import dev.thorinwasher.entity.attack.Attack;
import dev.thorinwasher.entity.attack.AttackType;
import dev.thorinwasher.entity.behavior.Behavior;
import dev.thorinwasher.entity.behavior.BehaviorType;
import dev.thorinwasher.namespace.Keyed;

import java.util.HashMap;

public class Registry<T extends Keyed> extends HashMap<NamespaceID, T> implements Keyed {

    public static final Registry<AttackType<?>> ATTACK_TYPES = AttackType.ATTACK_TYPES;
    public static final Registry<Attack> ATTACKS = JsonRegistryDecoder.parse("/entity/attack", Decoders.ATTACK);
    public static final Registry<BehaviorType<?>> BEHAVIOR_TYPES = BehaviorType.BEHAVIOR_TYPES;
    public static final Registry<Behavior> BEHAVIORS = JsonRegistryDecoder.parse("/entity/behavior", Decoders.BEHAVIOR);
    public static final Registry<MovementBehavior> MOVEMENT_BEHAVIORS = JsonRegistryDecoder.parse("/entity/movement", Decoders.MOVEMENT);
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
