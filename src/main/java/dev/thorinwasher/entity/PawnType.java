package dev.thorinwasher.entity;

import net.minestom.server.entity.EntityType;
import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.entity.attack.Attack;
import dev.thorinwasher.entity.behavior.Behavior;
import dev.thorinwasher.namespace.Keyed;

import java.util.List;

public record PawnType(List<Behavior> entityBehaviors, List<Attack> attacks, NamespaceID key, EntityType entityType,
                       String name, float maxHealth, MovementBehavior movementBehavior) implements Keyed {

    private static final String PAWN_FILE_LOCATION = "/entity/pawn/";

}
